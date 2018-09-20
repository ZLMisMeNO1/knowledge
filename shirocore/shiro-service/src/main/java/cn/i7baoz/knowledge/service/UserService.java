package cn.i7baoz.knowledge.service;

import cn.i7baoz.knowledge.model.dto.LoginUserPersonDto;
import cn.i7baoz.knowledge.model.standard.UserBean;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
public interface UserService {

    /**
     * 获取人员的信息
     * @param code
     * @return
     */
    LoginUserPersonDto getPersonDetail(String code);
}
