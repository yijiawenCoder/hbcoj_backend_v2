package com.yijiawenCoder.hbcoj_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yijiawenCoder.hbcoj_backend.model.dto.post.HbcPostsQueryRequest;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcPosts;
import com.yijiawenCoder.hbcoj_backend.model.vo.HbcPostsVO;
import com.yijiawenCoder.hbcoj_backend.service.HbcPostsService;
import com.yijiawenCoder.hbcoj_backend.mapper.HbcPostsMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
* @author 26510
* @description 针对表【hbc_posts(帖子表)】的数据库操作Service实现
* @createDate 2024-07-21 14:40:29
*/
@Service
public class HbcPostsServiceImpl extends ServiceImpl<HbcPostsMapper, HbcPosts>
    implements HbcPostsService{

    @Override
    public void validHbcPosts(HbcPosts post, boolean add) {

    }

    @Override
    public QueryWrapper<HbcPosts> getQueryWrapper(HbcPostsQueryRequest postQueryRequest) {
        return null;
    }

    @Override
    public Page<HbcPosts> searchFromEs(HbcPostsQueryRequest postQueryRequest) {
        return null;
    }

    @Override
    public HbcPostsVO getHbcPostsVO(HbcPosts post, HttpServletRequest request) {
        return null;
    }

    @Override
    public Page<HbcPostsVO> getHbcPostsVOPage(Page<HbcPosts> postPage, HttpServletRequest request) {
        return null;
    }
}




