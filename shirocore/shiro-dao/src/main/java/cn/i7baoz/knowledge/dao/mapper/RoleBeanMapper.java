package cn.i7baoz.knowledge.dao.mapper;

import cn.i7baoz.model.standard.RoleBean;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleBeanMapper {
    /**
     *
     * @mbggenerated 2018-09-14
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    int insert(RoleBean record);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    int batchInsert(@Param("list") List<RoleBean> list);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    int batchUpdateChanged(@Param("list") List<RoleBean> list);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    int insertSelective(RoleBean record);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    RoleBean selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    int updateByPrimaryKeySelective(RoleBean record);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    int updateByPrimaryKey(RoleBean record);
}