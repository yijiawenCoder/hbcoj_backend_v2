package com.yijiawenCoder.hbcoj_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yijiawenCoder.hbcoj_backend.model.dto.comment.HbcCommentAddRequest;
import com.yijiawenCoder.hbcoj_backend.model.dto.comment.HbcCommentsQueryRequest;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcComments;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcThumbs;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcUsers;
import com.yijiawenCoder.hbcoj_backend.model.enums.DeleteStateEnum;
import com.yijiawenCoder.hbcoj_backend.model.enums.ServiceTypeEnum;
import com.yijiawenCoder.hbcoj_backend.model.vo.CommentsVO;
import com.yijiawenCoder.hbcoj_backend.service.HbcCommentsService;
import com.yijiawenCoder.hbcoj_backend.mapper.HbcCommentsMapper;
import com.yijiawenCoder.hbcoj_backend.service.HbcUsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.yijiawenCoder.hbcoj_backend.constant.UserConstant.USER_LOGIN_STATE;

/**
 * @author 26510
 * @description 针对表【hbc_comments(评论表)】的数据库操作Service实现
 * @createDate 2024-07-21 14:29:31
 */
@Service
public class HbcCommentsServiceImpl extends ServiceImpl<HbcCommentsMapper, HbcComments>
        implements HbcCommentsService {
    @Resource
    HbcCommentsMapper hbcCommentsMapper;
    @Resource
    HbcUsersService usersService;


    @Override
    public boolean addComment(HbcCommentAddRequest hbcCommentAddRequest, HttpServletRequest request) {
        HbcUsers loginUser = usersService.getLoginUser(request);
        HbcComments hbcComments = new HbcComments();
        BeanUtils.copyProperties(hbcCommentAddRequest, hbcComments);
        hbcComments.setCommentId(ServiceTypeEnum.COMMENT.getServiceId() + ":" + hbcComments.getCommentId());

        hbcComments.setServiceType(ServiceTypeEnum.COMMENT.getValue());
        hbcComments.setUserId(loginUser.getUserId());
        hbcComments.setCreateTime(new Timestamp(new java.util.Date().getTime()));
        hbcComments.setUpdateTime(new Timestamp(new java.util.Date().getTime()));
        hbcComments.setIsDelete(DeleteStateEnum.NORMAL.getValue());


        return this.save(hbcComments);
    }

    @Override
    public boolean deleteComment(String id) {
        return this.removeById(id);
    }

    /**
     * 根据题目id查询一级评论
     *
     * @param hbcCommentsQueryRequest
     * @return
     */
    @Override
    public List<CommentsVO> getComments(HbcCommentsQueryRequest hbcCommentsQueryRequest) {
        QueryWrapper<HbcComments> queryWrapper = new QueryWrapper<HbcComments>();
        queryWrapper.eq("root_id", hbcCommentsQueryRequest.getRootId());
        queryWrapper.eq("service_id", hbcCommentsQueryRequest.getServiceId());
        List<HbcComments> hbcCommentList = hbcCommentsMapper.selectList(queryWrapper);
        List<CommentsVO> commentVOList = new ArrayList<>();
        for (HbcComments hbcComments : hbcCommentList) {
            CommentsVO commentsVO = new CommentsVO();
            BeanUtils.copyProperties(hbcComments, commentsVO);
            commentVOList.add(commentsVO);
        }

        //TODO 异步线程把子评论查询出来
        return commentVOList;

    }


}




