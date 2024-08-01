package com.yijiawenCoder.hbcoj_backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 查看表
 * @TableName hbc_views
 */
@TableName(value ="hbc_views")
@Data
public class HbcViews implements Serializable {
    /**
     * 查看唯一ID
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String viewId;

    /**
     * 业务id
     */
    private String serviceId;

    /**
     * 业务类型
     */
    private Integer serviceType;

    /**
     * 查看关联查看的用户id
     */
    private String userId;

    /**
     * 如果业务类型是题目则记录用户代码
     */
    private String userCode;

    /**
     * 查看的创建时间
     */
    private Date createTime;

    /**
     * 查看的更新时间
     */
    private Date updateTime;

    /**
     * 查看的逻辑删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}