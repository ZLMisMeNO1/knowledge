package cn.i7baoz.model.standard;

import java.io.Serializable;
import java.util.Date;

public class RoleBean implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

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
     * shiro_role
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
     * 角色名称
     * @return name 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 角色名称
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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