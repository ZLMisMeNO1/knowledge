package cn.i7baoz.knowledge.resp;

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
public class KnowledgeResponseBody implements Serializable {

    private String code;

    private String message;

    private Object body;
}
