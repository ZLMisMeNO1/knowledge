package cn.i7baoz.knowledge.model.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Data
@Builder
public class ShiroUserDto implements Serializable {
    private Long id;

    private String name;
}
