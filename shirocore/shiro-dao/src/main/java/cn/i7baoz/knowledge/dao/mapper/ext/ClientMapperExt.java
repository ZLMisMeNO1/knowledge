package cn.i7baoz.knowledge.dao.mapper.ext;

import cn.i7baoz.knowledge.model.standard.ClientBean;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
public interface ClientMapperExt {

    /**
     * 根据key查找客户端
     * @param key
     * @return
     */
    ClientBean findByKey(String key);

}
