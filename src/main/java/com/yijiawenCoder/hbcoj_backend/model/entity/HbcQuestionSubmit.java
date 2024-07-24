package com.yijiawenCoder.hbcoj_backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 题目提交表
 * @TableName hbc_question_submit
 */
@TableName(value ="hbc_question_submit")
@Data
public class HbcQuestionSubmit implements Serializable {
    /**
     * 题目提交id
     */
    @TableId
    private String questionSubmitId;

    /**
     *  提交代码
     */
    private String questionSubmitCode;

    /**
     *  判题信息（json 对象）
     */
    private String judgeInfo;

    /**
     *  判题状态（0 - 待判题、1 - 判题中、2 - 成功、3 - 失败）
     */
    private Integer questionSubmitStatus;

    /**
     * 题目id
     */
    private String questionId;

    /**
     * 提交的用户id
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