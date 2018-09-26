package cn.i7baoz.knowledge.dao.mapper.standard;

import cn.i7baoz.knowledge.model.standard.ClientBean;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClientBeanMapper {
    /**
     *
     * @mbggenerated 2018-09-26
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-09-26
     */
    int insert(ClientBean record);

    /**
     *
     * @mbggenerated 2018-09-26
     */
    int batchInsert(@Param("list") List<ClientBean> list);

    /**
     *
     * @mbggenerated 2018-09-26
     */
    int batchUpdateChanged(@Param("list") List<ClientBean> list);

    /**
     *
     * @mbggenerated 2018-09-26
     */
    int insertSelective(ClientBean record);

    /**
     *
     * @mbggenerated 2018-09-26
     */
    ClientBean selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-09-26
     */
    int updateByPrimaryKeySelective(ClientBean record);

    /**
     *
     * @mbggenerated 2018-09-26
     */
    int updateByPrimaryKey(ClientBean record);
}