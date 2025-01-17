package com.yijiawenCoder.hbcoj_backend.service;

import com.yijiawenCoder.hbcoj_backend.model.dto.comment.HbcCommentAddRequest;
import com.yijiawenCoder.hbcoj_backend.model.dto.comment.HbcCommentsQueryRequest;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcComments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yijiawenCoder.hbcoj_backend.model.vo.CommentsVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 26510
* @description 针对表【hbc_comments(评论表)】的数据库操作Service
* @createDate 2024-07-21 14:29:31
*/
@Service
public interface HbcCommentsService extends IService<HbcComments> {
    boolean  addComment(HbcCommentAddRequest hbcCommentAddRequest, HttpServletRequest httpServletRequest);
    boolean deleteComment(String id,HttpServletRequest request);
   List<CommentsVO> getComments(HbcCommentsQueryRequest hbcCommentsQueryRequest,HttpServletRequest request);


}
