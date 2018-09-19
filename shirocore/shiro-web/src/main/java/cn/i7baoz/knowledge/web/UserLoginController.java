package cn.i7baoz.knowledge.web;

import cn.i7baoz.knowledge.resp.UserLoginResp;
import cn.i7baoz.model.dto.ShiroUserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
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
    public UserLoginResp tologin(HttpServletRequest request,String username,String password,Boolean rememberMe) {

        UsernamePasswordToken token = new UsernamePasswordToken(
                username,password,rememberMe
        );
        try {
            SecurityUtils.getSubject().login(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Session session = SecurityUtils.getSubject().getSession();
//        ShiroUserDto dto = (ShiroUserDto) session.getAttribute("currentUser");
        return UserLoginResp.builder().userId(1000L).username("zhang").build();
    }


}
