package cn.i7baoz.knowledge.dao.mapper.ext;

import cn.i7baoz.knowledge.model.standard.UserBean;
import org.apache.ibatis.annotations.Param;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
public interface UserMapperExt {

    /**
     * 通过code查询账号信息
     * @param code 用户名
     * @return
     */
    UserBean findUserByCode(@Param("code") String code) ;
}
