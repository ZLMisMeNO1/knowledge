package cn.i7baoz.knowledge.dao.mapper.ext;

import cn.i7baoz.knowledge.model.standard.PersonBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
public interface PersonMapperExt {

    /**
     * 根据账号id查询身份列表
     * @param userId
     * @return
     */
    List<PersonBean> findPersonListByUserId(@Param("userId") Long userId);
}
