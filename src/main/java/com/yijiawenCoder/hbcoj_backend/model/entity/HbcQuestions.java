package com.yijiawenCoder.hbcoj_backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 题目表
 * @TableName hbc_questions
 */
@TableName(value ="hbc_questions")
@Data
public class HbcQuestions implements Serializable {
    /**
     * 题目唯一ID
     */
    @TableId
    private String questionId;

    /**
     *  题目标题
     */
    private String questionTitle;

    /**
     *  题目内容
     */
    private String questionContent;

    /**
     *  题目标签列表（json 数组）
     */
    private String questionTags;

    /**
     *  题目答案
     */
    private String questionAnswer;

    /**
     * 判题用例（json 数组）
     */
    private String judgeCase;

    /**
     * 判题配置（json 对象）
     */
    private String judgeConfig;

    /**
     * 创建用户 id
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
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}