package com.yijiawenCoder.hbcoj_backend.model.dto.post;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class HbcPostsQueryRequest implements Serializable {
    /**
     *  帖子唯一ID
     */

    private String postId;

    /**
     * 帖子标题
     */
    private String postTitle;

    /**
     * 帖子内容
     */
    private String postContent;
    /**
     * 搜索词
     */
    private String searchText;
    /**
     * 帖子标签
     */
    private String postTags;

    /**
     * 标签列表
     */
    private List<String> tags;
    /**
     * 至少有一个标签
     */
    private List<String> orTags;

    /**
     * 帖子热度值
     */
    private String postHotpoint;

    /**
     * 发帖用户id
     */
    private String userId;

    /**
     * 收藏用户 id
     */
    private Long favourUserId;


    private static final long serialVersionUID = 1L;
}
