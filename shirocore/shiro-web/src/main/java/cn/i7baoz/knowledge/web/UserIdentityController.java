package cn.i7baoz.knowledge.web;

import cn.i7baoz.knowledge.model.dto.LoginUserPersonDto;
import cn.i7baoz.knowledge.model.standard.PersonBean;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@RestController
@RequestMapping("/s/user")
public class UserIdentityController {

    @PostMapping("/getPersonDetail")
    public PersonBean getPersonDetail() {
        LoginUserPersonDto dto = (LoginUserPersonDto) SecurityUtils.getSubject().getPrincipal();
        return dto.getIdentityList().get(0);
    }
}
