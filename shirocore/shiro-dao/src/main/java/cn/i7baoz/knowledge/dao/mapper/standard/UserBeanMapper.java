package cn.i7baoz.knowledge.dao.mapper.standard;

import cn.i7baoz.knowledge.model.standard.UserBean;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBeanMapper {
    /**
     *
     * @mbggenerated 2018-09-20
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    int insert(UserBean record);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    int batchInsert(@Param("list") List<UserBean> list);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    int batchUpdateChanged(@Param("list") List<UserBean> list);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    int insertSelective(UserBean record);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    UserBean selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    int updateByPrimaryKeySelective(UserBean record);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    int updateByPrimaryKey(UserBean record);
}