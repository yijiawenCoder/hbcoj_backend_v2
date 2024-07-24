package com.yijiawenCoder.hbcoj_backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 帖子表
 * @TableName hbc_posts
 */
@TableName(value ="hbc_posts")
@Data
public class HbcPosts implements Serializable {
    /**
     *  帖子唯一ID 
     */
    @TableId
    private String postId;

    /**
     * 帖子标题 
     */
    private String postTitle;

    /**
     * 帖子内容 
     */
    private String postContent;

    /**
     * 帖子标签 
     */
    private String postTags;

    /**
     * 帖子热度值 
     */
    private String postHotpoint;

    /**
     * 发帖用户id 
     */
    private String userId;

    /**
     * 创建时间 
     */
    private Date createTime;

    /**
     * 更新时间 
     */
    private Date updateTime;

    /**
     * 逻辑删除 
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}