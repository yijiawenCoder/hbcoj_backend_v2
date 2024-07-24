package com.yijiawenCoder.hbcoj_backend.controller;

import com.yijiawenCoder.hbcoj_backend.common.BaseResponse;
import com.yijiawenCoder.hbcoj_backend.common.ErrorCode;
import com.yijiawenCoder.hbcoj_backend.exception.BusinessException;
import com.yijiawenCoder.hbcoj_backend.model.dto.UserRegisterRequest;
import com.yijiawenCoder.hbcoj_backend.service.HbcUsersService;
import com.yijiawenCoder.hbcoj_backend.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *  用户相关接口
 * @author yijiawenCoder
 * @Date 2024/7/21 17:04
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

@Resource
private HbcUsersService userService;



    public UserController() {
    }

    @PostMapping("/userRegister")
    public BaseResponse<String> Register(@RequestBody UserRegisterRequest userRegisterRequest){


        String userRegisterId = userService.userRegister(userRegisterRequest);
            return ResultUtils.success(userRegisterId);

    }








}
