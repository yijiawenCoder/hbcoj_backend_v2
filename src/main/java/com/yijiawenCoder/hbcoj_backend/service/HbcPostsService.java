package com.yijiawenCoder.hbcoj_backend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yijiawenCoder.hbcoj_backend.model.dto.post.HbcPostsQueryRequest;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcPosts;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcPosts;
import com.yijiawenCoder.hbcoj_backend.model.vo.HbcPostsVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 26510
* @description 针对表【hbc_posts(帖子表)】的数据库操作Service
* @createDate 2024-07-21 14:40:29
*/
public interface HbcPostsService extends IService<HbcPosts> {
    /**
     * 校验
     *
     * @param post
     * @param add
     */
    void validHbcPosts(HbcPosts post, boolean add);

    /**
     * 获取查询条件
     *
     * @param postQueryRequest
     * @return
     */
    QueryWrapper<HbcPosts> getQueryWrapper(HbcPostsQueryRequest postQueryRequest);

    /**
     * 从 ES 查询
     *
     * @param postQueryRequest
     * @return
     */
    Page<HbcPosts> searchFromEs(HbcPostsQueryRequest postQueryRequest);

    /**
     * 获取帖子封装
     *
     * @param post
     * @param request
     * @return
     */
    HbcPostsVO getHbcPostsVO(HbcPosts post, HttpServletRequest request);

    /**
     * 分页获取帖子封装
     *
     * @param postPage
     * @param request
     * @return
     */
    Page<HbcPostsVO> getHbcPostsVOPage(Page<HbcPosts> postPage, HttpServletRequest request);


}
