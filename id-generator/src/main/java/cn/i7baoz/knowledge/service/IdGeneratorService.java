package cn.i7baoz.knowledge.service;

import cn.i7baoz.knowledge.config.GeneratorConfig;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
public interface IdGeneratorService {

    /**
     * 生产id
     *
     * @return id
     */
    Long generateId();

    /**
     * 解析id
     *
     * @param id 生产的id
     * @return
     */
    GeneratorConfig parseId(Long id);

    /**
     * 开始时间2018-01-01 00:00:00
     */
    Long startTime = 1514736000000L;

}
