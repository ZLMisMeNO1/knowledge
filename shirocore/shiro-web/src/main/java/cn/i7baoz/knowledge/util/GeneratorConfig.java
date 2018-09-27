package cn.i7baoz.knowledge.util;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Data
@Builder
public class GeneratorConfig implements Serializable {


    /**
     * 当前时间毫秒值
     */
    private Date time;

    /**
     * 数据中心值
     */
    private Long datacenterId;

    /**
     * 机器号
     */
    private Long workerId;

    /**
     * 序列值
     */
    private Long sequence;
}
