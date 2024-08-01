package com.yijiawenCoder.hbcoj_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcThumbs;
import com.yijiawenCoder.hbcoj_backend.model.enums.DeleteStateEnum;
import com.yijiawenCoder.hbcoj_backend.model.enums.ServiceTypeEnum;
import com.yijiawenCoder.hbcoj_backend.service.HbcThumbsService;
import com.yijiawenCoder.hbcoj_backend.mapper.HbcThumbsMapper;
import com.yijiawenCoder.hbcoj_backend.service.HbcUsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
* @author 26510
* @description 针对表【hbc_thumbs(点赞表)】的数据库操作Service实现
* @createDate 2024-07-21 14:40:39
*/
@Service
public class HbcThumbsServiceImpl extends ServiceImpl<HbcThumbsMapper, HbcThumbs>
    implements HbcThumbsService{
    @Resource
    HbcUsersService usersService;

    @Override
    public boolean thumbComment(String commentId, HttpServletRequest request) {
        HbcThumbs thumbs = new HbcThumbs();
        thumbs.setThumbId(ServiceTypeEnum.COMMENT.getServiceId()+":"+thumbs.getThumbId());
        thumbs.setServiceId(ServiceTypeEnum.COMMENT.getServiceId());
        thumbs.setServiceType(ServiceTypeEnum.COMMENT.getValue());
        thumbs.setUserId(usersService.getLoginUser(request).getUserId());
        thumbs.setCreateTime(new Timestamp(new java.util.Date().getTime()));
        thumbs.setUpdateTime(new Timestamp(new java.util.Date().getTime()));
        thumbs.setIsDelete(DeleteStateEnum.NORMAL.getValue());

        return this.save(thumbs);
    }

}




