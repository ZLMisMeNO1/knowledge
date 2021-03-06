package cn.i7baoz.knowledge.model.standard;

import java.io.Serializable;
import java.util.Date;

public class ClientBean implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 客户端名称
     */
    private String name;

    /**
     * 客户端key
     */
    private String keySecrity;

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
     * shiro_client
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
     * 客户端名称
     * @return name 客户端名称
     */
    public String getName() {
        return name;
    }

    /**
     * 客户端名称
     * @param name 客户端名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 客户端key
     * @return key_secrity 客户端key
     */
    public String getKeySecrity() {
        return keySecrity;
    }

    /**
     * 客户端key
     * @param keySecrity 客户端key
     */
    public void setKeySecrity(String keySecrity) {
        this.keySecrity = keySecrity == null ? null : keySecrity.trim();
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