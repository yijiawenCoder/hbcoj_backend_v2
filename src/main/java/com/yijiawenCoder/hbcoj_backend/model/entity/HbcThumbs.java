package com.yijiawenCoder.hbcoj_backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 点赞表
 * @TableName hbc_thumbs
 */
@TableName(value ="hbc_thumbs")
@Data
public class HbcThumbs implements Serializable {
    /**
     * 点赞唯一ID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String thumbId;

    /**
     * 业务id
     */
    private String serviceId;

    /**
     * 业务类型
     */
    private Integer serviceType;

    /**
     * 点赞关联点赞的用户id
     */
    private String userId;

    /**
     * 点赞的创建时间
     */
    private Date createTime;

    /**
     * 点赞的更新时间
     */
    private Date updateTime;

    /**
     * 点赞的逻辑删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}