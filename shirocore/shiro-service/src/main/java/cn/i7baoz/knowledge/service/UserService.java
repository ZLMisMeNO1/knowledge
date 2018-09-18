package cn.i7baoz.knowledge.service;

import cn.i7baoz.model.standard.UserBean;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
public interface UserService {

    /**
     * 获取用户
     * @param id
     * @return
     */
    UserBean getUserById(Long id);
}
