package com.yijiawenCoder.hbcoj_backend.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CommentsVO implements Serializable {
    /**
     * 评论唯一id
     */
    private String commentId;

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
     * 子评论
     */
    private List<CommentsVO> childCommentList;

    /**
     * 引用id
     */
    private String refId;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

}

