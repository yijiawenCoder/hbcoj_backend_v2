package com.yijiawenCoder.hbcoj_backend.model.dto.comment;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class HbcCommentAddRequest implements Serializable {


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




    private static final long serialVersionUID = 1L;
}
