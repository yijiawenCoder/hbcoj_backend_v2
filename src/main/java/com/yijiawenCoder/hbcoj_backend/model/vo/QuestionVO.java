package com.yijiawenCoder.hbcoj_backend.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcUsers;

import java.io.Serializable;
import java.util.Date;

public class QuestionVO implements Serializable {
    /**
     * 题目唯一ID
     */

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
     * 题目提交数
     */
    private Integer QuestionSubmitNum;

    /**
     * 题目通过数
     */
    private Integer QuestionAcceptedNum;



    /**
     * 判题配置（json 对象）
     */
    private String judgeConfig;


    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;
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
     * 创建人信息
     */
    private HbcUsers userVO;
    private static final long serialVersionUID = 1L;
}
