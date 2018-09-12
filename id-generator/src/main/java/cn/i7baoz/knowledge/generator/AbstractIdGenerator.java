package cn.i7baoz.knowledge.generator;

import cn.i7baoz.knowledge.config.GeneratorConfig;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

/**
 * @Title:
 * @Package
 * @Description: 组成id方式 0- 41位时间戳 - 5位数据中心-5位机器id-12位序列
 * @author: baoqi.zhang
 * @date:
 */
@Slf4j
public abstract class AbstractIdGenerator {

    private long sequenceBits = 12L;

    private long datacenterIdBits = 5L;

    private long workerIdBits = 5L;

    private long timeBits = 41L;
    /**
     * 序列偏移位置
     */
    private long sequenceShift = 0L;

    /**
     * 机器号偏移位置
     */
    private long workerShift = sequenceBits;

    /**
     * 数据中心偏移位置
     */
    private long datacenterShift = sequenceBits + workerIdBits;

    /**
     * 时间偏移位置
     */
    private long timeShift = sequenceBits + workerIdBits + datacenterIdBits;

    /**
     * 数据中心id最大值
     */
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    private long sequenceMark = -1L ^ (-1L << sequenceBits);
    /**
     * 机器id最大值
     */
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /**
     * 上一次的时间值
     */
    private long lastTimeMills = -1L;

    /**
     * 序列初始值
     */
    private Long sequence = 0L;

    /**
     * 开始时间 2018-01-01 00:00:00
     */
    private long startTime = 1514736000000L;

    protected synchronized Long nextId(Long datacenterId, Long workerId) {

        if (workerId == null || workerId > maxWorkerId || workerId < 0) {
            log.error("maxWorkerId【{}】 不能为空、不能为负数且不能大于{}", workerId, maxWorkerId);
            throw new IllegalArgumentException(String.format("maxWorkerId【%d】 不能为空、不能为负数且不能大于%d", workerId, maxWorkerId));
        }
        if (datacenterId == null || datacenterId > maxDatacenterId || datacenterId < 0) {
            log.error("datacenterId【{}】 不能为空、不能为负数且不能大于{}", datacenterId, maxDatacenterId);
            throw new IllegalArgumentException(String.format("datacenterId【%d】 不能为空、不能为负数且不能大于%d", datacenterId, maxDatacenterId));
        }
        Long time = timeGen();
        if (time <= startTime) {
            log.error("不允许篡改时间");
            throw new RuntimeException("clock is moved !");
        }
        if (lastTimeMills == time) {
            sequence = sequence & (sequenceMark + 1);
            if (sequence == 0) {
                time = tilNextTimeMill(lastTimeMills);
            }
        } else {
            sequence = 0L;
        }
        lastTimeMills = time;

        return sequence
                | (workerId << workerShift)
                | (datacenterId << datacenterShift )
                | (((time - startTime) << timeShift));
    }

    /**
     * 获取当前时间毫秒值
     *
     * @return
     */
    protected long timeGen() {

        return System.currentTimeMillis();
    }

    /**
     * @param lastTimeMills
     * @return
     */
    protected long tilNextTimeMill(long lastTimeMills) {
        long time = timeGen();
        while (time <= lastTimeMills) {
            time = timeGen();
        }
        return time;
    }

    /**
     * 生产id
     *
     * @return id
     */
    protected abstract Long generateId();

    /**
     * 解析id
     *
     * @param id 生产的id
     * @return
     */
    public GeneratorConfig parseId(Long id) {
        if (id == null || id < startTime ) {
            log.error("id is null or id is invalid ");
            throw new IllegalArgumentException("id is null or id is invalid ");
        }
        GeneratorConfig.GeneratorConfigBuilder builder = GeneratorConfig.builder();
        builder.sequence( (id >> sequenceShift ) & ( (1L << sequenceBits ) - 1 ))
                .workerId((id >> workerShift) & ( (1L << workerIdBits) -1 ))
                .datacenterId( id >> datacenterShift & ((1L << datacenterIdBits) -1 ))
                .time(new Timestamp((id >> timeShift & ((1L << timeBits) -1 ))));
        return builder.build();
    }

}
