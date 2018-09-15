package cn.i7baoz.knowledge;

//import cn.i7baoz.model.standard.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("test")
public class TestController {

    @RequestMapping("index")
    public String index() {
        return "hello world";
    }

//    @Autowired
//    private UserService userService;

//
}
