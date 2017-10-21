package com.xavier.domain;

import com.xavier.domain.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * <p>用户Entity</p>
 * 
 * @author NewGr8Player
 * @date 2017/10/21
 */
@Entity
@ApiModel
@Table(name = "d_content")
public class Article extends BaseEntity {

    @Column(name = "title")
    @ApiParam(name = "title", value = "文章标题", required = true)
    private String title;

    @Column(name = "content")
    @ApiParam(name = "content", value = "文章内容", required = true)
    private String content;

    @Column(name = "read_count")
    @ApiParam(hidden = true)
    private BigDecimal readCount;

    public Article() {
        super();
        this.readCount = new BigDecimal("0");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getReadCount() {
        return readCount;
    }
}
