package cn.i7baoz.knowledge.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Controller
public class AuthorizeController {

    @RequestMapping("toLogin")
    public String loginPage(){
        return "login";
    }
}
