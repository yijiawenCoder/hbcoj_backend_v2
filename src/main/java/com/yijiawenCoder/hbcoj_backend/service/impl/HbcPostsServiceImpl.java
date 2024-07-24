package com.yijiawenCoder.hbcoj_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcPosts;
import com.yijiawenCoder.hbcoj_backend.service.HbcPostsService;
import com.yijiawenCoder.hbcoj_backend.mapper.HbcPostsMapper;
import org.springframework.stereotype.Service;

/**
* @author 26510
* @description 针对表【hbc_posts(帖子表)】的数据库操作Service实现
* @createDate 2024-07-21 14:40:29
*/
@Service
public class HbcPostsServiceImpl extends ServiceImpl<HbcPostsMapper, HbcPosts>
    implements HbcPostsService{

}




