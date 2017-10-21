package com.xavier.domain.base;

import io.swagger.annotations.ApiParam;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>提取公共字段,作为基类</p>
 * 
 * @author NewGr8Player
 * @date 2017/10/21
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    @ApiParam(hidden = true)
    private String id;

    @Column(name = "create_date",updatable = false)
    @ApiParam(hidden = true)
    private Date createDate;

    @Column(name = "edit_date")
    private Date editDate;

    public BaseEntity() {
        this.createDate = new Date();
        this.editDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }
}
