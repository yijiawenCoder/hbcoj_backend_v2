package com.yijiawenCoder.hbcoj_backend.controller;

import com.yijiawenCoder.hbcoj_backend.common.BaseResponse;
import com.yijiawenCoder.hbcoj_backend.model.dto.comment.HbcCommentAddRequest;
import com.yijiawenCoder.hbcoj_backend.model.dto.comment.HbcCommentsQueryRequest;
import com.yijiawenCoder.hbcoj_backend.model.vo.CommentsVO;
import com.yijiawenCoder.hbcoj_backend.service.HbcCommentsService;
import com.yijiawenCoder.hbcoj_backend.utils.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    HbcCommentsService hbcCommentsService;

    @PostMapping("/add")
    public BaseResponse<Boolean> addComment(HbcCommentAddRequest hbcCommentAddRequest, HttpServletRequest request) {
        String serviceId = hbcCommentAddRequest.getServiceId();
        Integer serviceType = hbcCommentAddRequest.getServiceType();
        String userId = hbcCommentAddRequest.getUserId();
        String commentContent = hbcCommentAddRequest.getCommentContent();
        String rootId = hbcCommentAddRequest.getRootId();
        String refId = hbcCommentAddRequest.getRefId();

        //TODO 校验参数
        boolean ok = hbcCommentsService.addComment(hbcCommentAddRequest, request);
        return ResultUtils.success(ok);


    }


    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteComment(String commentId, HttpServletRequest request) {

        hbcCommentsService.deleteComment(commentId, request)      ;
        return   ResultUtils.success(true);

    }


    @GetMapping("getCommentList")
    public BaseResponse<List<CommentsVO>> getCommentList(HbcCommentsQueryRequest hbcCommentsQueryRequest,HttpServletRequest request){
        List<CommentsVO> comments = hbcCommentsService.getComments(hbcCommentsQueryRequest, request);
        return ResultUtils.success(comments);

    }

}
