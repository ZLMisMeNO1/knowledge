package cn.i7baoz.knowledge.model.standard;

import java.io.Serializable;
import java.util.Date;

public class UserBean implements Serializable {
    /**
     * id
     */
    private Long id;

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
     * shiro_user
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
     * 用户密码
     * @return password_hash 用户密码
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * 用户密码
     * @param passwordHash 用户密码
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash == null ? null : passwordHash.trim();
    }

    /**
     * 密码盐
     * @return salt 密码盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 密码盐
     * @param salt 密码盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 是否删除 1：删除
     * @return is_del 是否删除 1：删除
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 是否删除 1：删除
     * @param isDel 是否删除 1：删除
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