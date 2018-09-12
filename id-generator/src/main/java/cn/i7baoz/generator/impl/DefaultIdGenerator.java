package cn.i7baoz.generator.impl;

import cn.i7baoz.generator.AbstractIdGenerator;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Slf4j
public class DefaultIdGenerator extends AbstractIdGenerator {

    private Long datacenterId;

    private Long workerId;

    public DefaultIdGenerator(long datacenterId, long workerId){
        this.datacenterId = datacenterId;
        this.workerId = datacenterId;
    }

    @Override
    public Long generateId() {
        return nextId(datacenterId,workerId);
    }
}