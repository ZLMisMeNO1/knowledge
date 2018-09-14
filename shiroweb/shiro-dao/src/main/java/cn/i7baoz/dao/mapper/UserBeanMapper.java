package cn.i7baoz.dao.mapper;

import cn.i7baoz.model.standard.UserBean;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBeanMapper {
    /**
     *
     * @mbggenerated 2018-09-14
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    int insert(UserBean record);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    int batchInsert(@Param("list") List<UserBean> list);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    int batchUpdateChanged(@Param("list") List<UserBean> list);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    int insertSelective(UserBean record);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    UserBean selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    int updateByPrimaryKeySelective(UserBean record);

    /**
     *
     * @mbggenerated 2018-09-14
     */
    int updateByPrimaryKey(UserBean record);
}