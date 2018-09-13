package cn.i7baoz.dao.mapper;

import cn.i7baoz.model.bean.UserBean;

public interface UserBeanMapper {
    /**
     *
     * @mbg.generated 2018-09-14
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-14
     */
    int insert(UserBean record);

    /**
     *
     * @mbg.generated 2018-09-14
     */
    int insertSelective(UserBean record);

    /**
     *
     * @mbg.generated 2018-09-14
     */
    UserBean selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-14
     */
    int updateByPrimaryKeySelective(UserBean record);

    /**
     *
     * @mbg.generated 2018-09-14
     */
    int updateByPrimaryKey(UserBean record);
}