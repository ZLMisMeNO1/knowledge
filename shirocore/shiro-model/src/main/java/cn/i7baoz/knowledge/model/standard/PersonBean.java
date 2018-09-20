package cn.i7baoz.knowledge.model.standard;

import java.io.Serializable;
import java.util.Date;

public class PersonBean implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 人员编码，登录账号，is_del为0状态全表唯一
     */
    private String code;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 身份 0：普通用户，1：普通管理员，2：超级管理员
     */
    private Long identity;

    /**
     * 
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
     * shiro_person
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     * @return id id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 昵称
     * @return nick_name 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 人员编码，登录账号，is_del为0状态全表唯一
     * @return code 人员编码，登录账号，is_del为0状态全表唯一
     */
    public String getCode() {
        return code;
    }

    /**
     * 人员编码，登录账号，is_del为0状态全表唯一
     * @param code 人员编码，登录账号，is_del为0状态全表唯一
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 身份 0：普通用户，1：普通管理员，2：超级管理员
     * @return identity 身份 0：普通用户，1：普通管理员，2：超级管理员
     */
    public Long getIdentity() {
        return identity;
    }

    /**
     * 身份 0：普通用户，1：普通管理员，2：超级管理员
     * @param identity 身份 0：普通用户，1：普通管理员，2：超级管理员
     */
    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    /**
     * 
     * @return is_del 
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 
     * @param isDel 
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * 创建人
     * @return created_by 创建人
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 创建人
     * @param createdBy 创建人
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 创建时间
     * @return created_date 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 创建时间
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 更新人
     * @return updated_by 更新人
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 更新人
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 更新时间
     * @return updated_date 更新时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 更新时间
     * @param updatedDate 更新时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}