package com.yijiawenCoder.hbcoj_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yijiawenCoder.hbcoj_backend.model.dto.post.HbcPostsQueryRequest;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcPosts;
import com.yijiawenCoder.hbcoj_backend.model.enums.DeleteStateEnum;
import com.yijiawenCoder.hbcoj_backend.model.vo.HbcPostsVO;
import com.yijiawenCoder.hbcoj_backend.service.HbcPostsService;
import com.yijiawenCoder.hbcoj_backend.mapper.HbcPostsMapper;
import com.yijiawenCoder.hbcoj_backend.service.HbcUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
* @author 26510
* @description 针对表【hbc_posts(帖子表)】的数据库操作Service实现
* @createDate 2024-07-21 14:40:29
*/
@Service
public class HbcPostsServiceImpl extends ServiceImpl<HbcPostsMapper, HbcPosts>
    implements HbcPostsService{
    @Resource
    HbcUsersService usersService;
    @Override
    public boolean addPost(HbcPosts hbcPosts, HttpServletRequest request) {





        hbcPosts.setUserId(usersService.getLoginUser(request).getUserId());
        hbcPosts.setCreateTime(new Timestamp(new java.util.Date().getTime()));
        hbcPosts.setUpdateTime(new Timestamp(new java.util.Date().getTime()));
        hbcPosts.setIsDelete(DeleteStateEnum.NORMAL.getValue());

        return this.save(hbcPosts);
    }

    @Override
    public boolean updatePost(HbcPosts hbcPosts, HttpServletRequest request) {


        hbcPosts.setUpdateTime(new Timestamp(new java.util.Date().getTime()));
      return this.updateById(hbcPosts);

    }

    @Override
    public boolean deletePost(HbcPosts hbcPosts, HttpServletRequest request) {
        return this.removeById(hbcPosts.getPostId());
    }

    @Override
    public List<HbcPostsVO> getHbcPostsVO(HbcPosts post, HttpServletRequest request) {
        return null;
    }
}




