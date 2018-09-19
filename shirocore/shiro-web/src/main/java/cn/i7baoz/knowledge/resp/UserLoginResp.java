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
public class UserLoginResp implements Serializable {

    private Long userId;

    private String username;

}
