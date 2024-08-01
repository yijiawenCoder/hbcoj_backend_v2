package com.yijiawenCoder.hbcoj_backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 行为日志表
 * @TableName oj_act_log
 */
@TableName(value ="oj_act_log")
@Data
public class OjActLog implements Serializable {
    /**
     * 行为日志唯一id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String logId;

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
    private String opUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}