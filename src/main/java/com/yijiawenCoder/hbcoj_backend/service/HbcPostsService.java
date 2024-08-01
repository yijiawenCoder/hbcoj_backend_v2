package com.yijiawenCoder.hbcoj_backend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yijiawenCoder.hbcoj_backend.model.dto.post.HbcPostsQueryRequest;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcPosts;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcPosts;
import com.yijiawenCoder.hbcoj_backend.model.vo.HbcPostsVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 26510
* @description 针对表【hbc_posts(帖子表)】的数据库操作Service
* @createDate 2024-07-21 14:40:29
*/
public interface HbcPostsService extends IService<HbcPosts> {

    boolean addPost(HbcPosts hbcPosts, HttpServletRequest request);
    boolean updatePost(HbcPosts hbcPosts, HttpServletRequest request);
    boolean deletePost(HbcPosts hbcPosts, HttpServletRequest request);

    /**
     * 获取帖子封装
     *
     * @param post
     * @param request
     * @return
     */
    List<HbcPostsVO> getHbcPostsVO(HbcPosts post, HttpServletRequest request);


}
