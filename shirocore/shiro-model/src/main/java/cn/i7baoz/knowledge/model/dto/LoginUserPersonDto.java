package cn.i7baoz.knowledge.model.dto;

import cn.i7baoz.knowledge.model.standard.PersonBean;
import cn.i7baoz.knowledge.model.standard.UserBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserPersonDto implements Serializable {

    /**
     * id
     */
    private Long userId;

    /**
     * 用户密码
     */
    private String passwordHash;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 是否删除 1：删除
     */
    private Integer isDel;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 更新人
     */
    private Long updatedBy;

    /**
     * 更新时间
     */
    private Date updatedDate;

    /**
     * 身份列表
     */
    private List<PersonBean> identityList;

    public static LoginUserPersonDto fromUserBean(UserBean userBean) {
        LoginUserPersonDto dto = new LoginUserPersonDto();
        BeanUtils.copyProperties(userBean,dto);
        dto.setUserId(userBean.getId());
        return dto;
    }
}
