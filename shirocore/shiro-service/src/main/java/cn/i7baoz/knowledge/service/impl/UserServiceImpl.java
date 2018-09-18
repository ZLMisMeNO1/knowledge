package cn.i7baoz.knowledge.service.impl;

import cn.i7baoz.knowledge.dao.mapper.UserBeanMapper;
import cn.i7baoz.model.standard.UserBean;
import cn.i7baoz.knowledge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBeanMapper userBeanMapper;

    @Override
    public UserBean getUserById(Long id) {
        return userBeanMapper.selectByPrimaryKey(id);
    }
}
