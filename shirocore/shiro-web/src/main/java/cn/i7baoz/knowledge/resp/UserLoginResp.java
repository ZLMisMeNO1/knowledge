package cn.i7baoz.knowledge.resp;

import cn.i7baoz.knowledge.model.standard.PersonBean;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Data
public class UserLoginResp implements Serializable {

    private Long userId;
    /**
     * 身份列表
     */
    private List<PersonBean> identityList;
}
