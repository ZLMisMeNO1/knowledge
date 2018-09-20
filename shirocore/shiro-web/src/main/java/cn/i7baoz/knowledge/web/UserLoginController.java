package cn.i7baoz.knowledge.web;

import cn.i7baoz.knowledge.model.dto.LoginUserPersonDto;
import cn.i7baoz.knowledge.resp.UserLoginResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@RestController
@Slf4j
@RequestMapping("/s/authc")
public class UserLoginController {

    @PostMapping("/toLogin")
    public UserLoginResp tologin(HttpServletRequest request, String username, String password, Boolean rememberMe) {

        UsernamePasswordToken token = new UsernamePasswordToken(
                username, password, rememberMe
        );
        try {
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException e) {
            log.info(e.getMessage());
            throw e;
        } catch (IncorrectCredentialsException e) {
            log.info("密码错误");
            throw e;
        } catch (Exception e) {
            log.info("系统错误:{}",e.getMessage());
            throw e;
        }
        LoginUserPersonDto dto = (LoginUserPersonDto) SecurityUtils.getSubject().getPrincipal();
        UserLoginResp resp = new UserLoginResp();
        BeanUtils.copyProperties(dto, resp);
        return resp;
    }


}
