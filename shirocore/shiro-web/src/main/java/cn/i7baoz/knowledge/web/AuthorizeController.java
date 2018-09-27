package cn.i7baoz.knowledge.web;

import cn.i7baoz.knowledge.exception.KnowledgeException;
import cn.i7baoz.knowledge.exception.KnowledgeMessageEnum;
import cn.i7baoz.knowledge.model.dto.LoginUserPersonDto;
import cn.i7baoz.knowledge.util.DefaultIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Controller
@Slf4j
public class AuthorizeController {

    @Autowired
    private DefaultIdGenerator idGenerator;

    @RequestMapping("authorize")
    public Object authorize(HttpServletRequest request) throws OAuthSystemException, URISyntaxException {
        try{
            OAuthAuthzRequest oAuthAuthzRequest = new OAuthAuthzRequest(request);

            String redirectURI = oAuthAuthzRequest.getRedirectURI();
            String responseType = oAuthAuthzRequest.getResponseType();
            String clientId = oAuthAuthzRequest.getClientId();
            //校验
            ResponseEntity responseEntity = assertRedirectUriNotNull(redirectURI);
            if (responseEntity != null) {
                return responseEntity;
            }
            Subject subject = SecurityUtils.getSubject();
            if (!login(subject, request)) {
                ModelAndView login = new ModelAndView("login");
                //没有登陆跳转到登陆页面
                login.addObject("client_id", clientId);
                login.addObject("response_type", responseType);
                login.addObject("redirect_uri", redirectURI);
                return login;
            }
            log.info("over");
            //获取当前用户信息
            LoginUserPersonDto principal = (LoginUserPersonDto)subject.getPrincipal();
            //生成授权码
            String authorizationCode = null;
            if (ResponseType.CODE.toString().equalsIgnoreCase(responseType)) {
                authorizationCode = new BigDecimal(idGenerator.generateId()).toString();
            }
            OAuthASResponse.OAuthAuthorizationResponseBuilder  builder =
                    OAuthASResponse.authorizationResponse(request, HttpServletResponse.SC_FOUND);
            builder.setCode(authorizationCode);

            final OAuthResponse response = builder.location(redirectURI).buildQueryMessage();
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI(response.getLocationUri()));
            return new ResponseEntity(headers, HttpStatus.valueOf(response.getResponseStatus()));
        }  catch (OAuthProblemException e) {
            ResponseEntity responseEntity = assertRedirectUriNotNull(e.getRedirectUri());
            if (responseEntity != null) {
                return responseEntity;
            }
            //返回错误消息（如?error=）
            final OAuthResponse response =
                    OAuthASResponse.errorResponse(HttpServletResponse.SC_FOUND)
                            .error(e).location(e.getRedirectUri()).buildQueryMessage();
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI(response.getLocationUri()));
            return new ResponseEntity(headers, HttpStatus.valueOf(response.getResponseStatus()));
        }
    }

    private ResponseEntity assertRedirectUriNotNull(String redirectURI) throws OAuthSystemException {
        if (StringUtils.isEmpty(redirectURI)) {
            OAuthResponse response = OAuthResponse
                    .errorResponse(HttpServletResponse.SC_BAD_REQUEST)
                    .setError(OAuthError.CodeResponse.INVALID_REQUEST)
                    .setErrorDescription("没有设置跳转路径")
                    .buildJSONMessage();
            return new ResponseEntity(response.getBody(), HttpStatus.valueOf(response.getResponseStatus()));
        }
        return null;
    }
    /**
     * 登陆
     * @param subject
     * @param request
     * @return
     */
    private Boolean login(Subject subject,HttpServletRequest request){
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                log.info("用户名/密码为空！禁止登陆");
                return false;
            }
            log.info("username ->{},password -> {}", username, password);

            subject.login(new UsernamePasswordToken(username,password));

            return true;
        }catch (UnknownAccountException e) {
            throw new KnowledgeException(KnowledgeMessageEnum.UNKNOWN_ACCOUNT);
        } catch (IncorrectCredentialsException e) {
            throw new KnowledgeException(KnowledgeMessageEnum.INVALIDE_CRED);
        }catch (Exception e) {
            throw new KnowledgeException(KnowledgeMessageEnum.SYSTEM_ERROR);
        }
    }
}
