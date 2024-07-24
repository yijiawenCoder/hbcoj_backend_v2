package com.yijiawenCoder.hbcoj_backend.mapper;

import com.yijiawenCoder.hbcoj_backend.model.entity.OjActLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 26510
* @description 针对表【oj_act_log(行为日志表)】的数据库操作Mapper
* @createDate 2024-07-21 14:40:51
* @Entity com.yijiawenCoder.hbcoj_backend.model.entity.OjActLog
*/
@Mapper
public interface OjActLogMapper extends BaseMapper<OjActLog> {

}



