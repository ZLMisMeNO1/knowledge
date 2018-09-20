package cn.i7baoz.knowledge.service.impl;

import cn.i7baoz.knowledge.dao.mapper.ext.PersonMapperExt;
import cn.i7baoz.knowledge.dao.mapper.ext.UserMapperExt;
import cn.i7baoz.knowledge.model.dto.LoginUserPersonDto;
import cn.i7baoz.knowledge.model.standard.PersonBean;
import cn.i7baoz.knowledge.model.standard.UserBean;
import cn.i7baoz.knowledge.service.UserService;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
    private UserMapperExt userMapperExt;

    @Autowired
    private PersonMapperExt personMapperExt;

    @Override
    public LoginUserPersonDto getPersonDetail(String code) {

        UserBean user = userMapperExt.findUserByCode(code);
        if (user == null) {
            return null;
        }
        List<PersonBean> personBeans = personMapperExt.findPersonListByUserId(user.getId());

        if (CollectionUtils.isEmpty(personBeans)) {
            //无身份也就无登录意义
            return null;
        }
        LoginUserPersonDto dto = LoginUserPersonDto.fromUserBean(user);
        dto.setIdentityList(personBeans);
        return dto;
    }
}
