package com.yijiawenCoder.hbcoj_backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 评论表
 * @TableName hbc_comments
 */
@TableName(value ="hbc_comments")
@Data
public class HbcComments implements Serializable {
    /**
     * 评论唯一id
     */
    @TableId
    private String commentId;

    /**
     * 业务id（可以是帖子，可以是短视频）
     */
    private String serviceId;

    /**
     * 业务类型
     */
    private Integer serviceType;

    /**
     * 发表用户的id
     */
    private String userId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 针对评论的根id
     */
    private String rootId;

    /**
     * 引用id
     */
    private String refId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     *  更新时间
     */
    private Date updateTime;

    /**
     *  是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}