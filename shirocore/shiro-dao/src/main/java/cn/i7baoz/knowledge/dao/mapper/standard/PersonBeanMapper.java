package cn.i7baoz.knowledge.dao.mapper.standard;

import cn.i7baoz.knowledge.model.standard.PersonBean;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonBeanMapper {
    /**
     *
     * @mbggenerated 2018-09-20
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    int insert(PersonBean record);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    int batchInsert(@Param("list") List<PersonBean> list);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    int batchUpdateChanged(@Param("list") List<PersonBean> list);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    int insertSelective(PersonBean record);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    PersonBean selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    int updateByPrimaryKeySelective(PersonBean record);

    /**
     *
     * @mbggenerated 2018-09-20
     */
    int updateByPrimaryKey(PersonBean record);
}