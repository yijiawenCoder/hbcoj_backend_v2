package com.yijiawenCoder.hbcoj_backend.model.dto.comment;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class HbcCommentsQueryRequest implements Serializable {
    /**
     * 评论唯一id
     */

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
     * 根据评论内容模糊查询
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
     *  是否删除
     */

    private Integer isDelete;


    private static final long serialVersionUID = 1L;
}
