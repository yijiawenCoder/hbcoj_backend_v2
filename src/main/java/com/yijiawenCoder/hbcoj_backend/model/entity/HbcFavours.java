package com.yijiawenCoder.hbcoj_backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 收藏表
 * @TableName hbc_favours
 */
@TableName(value ="hbc_favours")
@Data
public class HbcFavours implements Serializable {
    /**
     * 收藏唯一ID
     */
    @TableId
    private String favourId;

    /**
     * 业务id
     */
    private String serviceId;

    /**
     * 业务类型
     */
    private Integer serviceType;

    /**
     * 收藏关联收藏的用户id
     */
    private String userId;

    /**
     * 收藏的创建时间
     */
    private Date createTime;

    /**
     * 收藏的更新时间
     */
    private Date updateTime;

    /**
     * 收藏的逻辑删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}