package com.yijiawenCoder.hbcoj_backend.mapper;

import com.yijiawenCoder.hbcoj_backend.model.entity.HbcUsers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 26510
* @description 针对表【hbc_users(用户表)】的数据库操作Mapper
* @createDate 2024-07-21 14:40:45
* @Entity com.yijiawenCoder.hbcoj_backend.model.entity.HbcUsers
*/
@Mapper
public interface HbcUsersMapper extends BaseMapper<HbcUsers> {

}




