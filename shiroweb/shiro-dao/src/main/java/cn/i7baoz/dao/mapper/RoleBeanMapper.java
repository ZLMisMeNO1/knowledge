package cn.i7baoz.dao.mapper;

import cn.i7baoz.model.bean.RoleBean;

public interface RoleBeanMapper {
    /**
     *
     * @mbg.generated 2018-09-14
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-14
     */
    int insert(RoleBean record);

    /**
     *
     * @mbg.generated 2018-09-14
     */
    int insertSelective(RoleBean record);

    /**
     *
     * @mbg.generated 2018-09-14
     */
    RoleBean selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-14
     */
    int updateByPrimaryKeySelective(RoleBean record);

    /**
     *
     * @mbg.generated 2018-09-14
     */
    int updateByPrimaryKey(RoleBean record);
}