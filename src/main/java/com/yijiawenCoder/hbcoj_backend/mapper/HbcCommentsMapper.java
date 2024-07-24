package com.yijiawenCoder.hbcoj_backend.mapper;

import com.yijiawenCoder.hbcoj_backend.model.entity.HbcComments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 26510
* @description 针对表【hbc_comments(评论表)】的数据库操作Mapper
* @createDate 2024-07-21 14:29:31
* @Entity com.yijiawenCoder.hbcoj_backend.model.entity.HbcComments
*/
@Mapper
public interface HbcCommentsMapper extends BaseMapper<HbcComments> {

}




