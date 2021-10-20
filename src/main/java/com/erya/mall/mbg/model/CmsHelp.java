package com.erya.mall.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class CmsHelp implements Serializable {
    private Long id;

    /**
     * 类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "类型")
    private Long categoryId;

    /**
     * 图标
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 标题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 展示状态0:展示，1：不展示
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "展示状态0:展示，1：不展示")
    private Integer showStatus;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private Integer readCount;

    /**
     * 内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内容")
    private String content;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", icon=").append(icon);
        sb.append(", title=").append(title);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", readCount=").append(readCount);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}