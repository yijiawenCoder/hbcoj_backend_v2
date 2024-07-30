package com.yijiawenCoder.hbcoj_backend.controller;

import com.yijiawenCoder.hbcoj_backend.common.BaseResponse;
import com.yijiawenCoder.hbcoj_backend.common.ErrorCode;
import com.yijiawenCoder.hbcoj_backend.exception.BusinessException;
import com.yijiawenCoder.hbcoj_backend.model.dto.user.UserLoginRequest;
import com.yijiawenCoder.hbcoj_backend.model.dto.user.UserRegisterRequest;
import com.yijiawenCoder.hbcoj_backend.model.dto.user.UserUpdateRequest;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcUsers;
import com.yijiawenCoder.hbcoj_backend.model.vo.LoginUserVO;
import com.yijiawenCoder.hbcoj_backend.service.HbcUsersService;
import com.yijiawenCoder.hbcoj_backend.utils.ResultUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    public BaseResponse<String> Register(@RequestBody UserRegisterRequest userRegisterRequest) {


        String userRegisterId = userService.userRegister(userRegisterRequest);
        return ResultUtils.success(userRegisterId);

    }

    @GetMapping("/userLogin")
    public BaseResponse<LoginUserVO> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        String userPassword = userLoginRequest.getUserPassword();
        String userAccount = userLoginRequest.getUserAccount();
        LoginUserVO loginUserVO = userService.userLogin(userAccount, userPassword, request);
        return ResultUtils.success(loginUserVO);
    }

    @GetMapping("/userDelete")
    public BaseResponse<String> userDelete(@RequestBody HbcUsers user, HttpServletRequest request) {

        String s = userService.deleteUser(user, request);
        return ResultUtils.success(s);
    }

    @PostMapping("/userUpdate")
    public BaseResponse<String> userUpdate(@RequestBody UserUpdateRequest userUpdateRequest, HttpServletRequest request) {
        HbcUsers hbcUsers = new HbcUsers();
        BeanUtils
                .copyProperties(userUpdateRequest, hbcUsers);
        String s = userService.updateUser(hbcUsers, request);
        return ResultUtils.success(s);


    }
    @GetMapping("/logout")
    public BaseResponse<Boolean> userLogout(HttpServletRequest request) {
        if(userService.getLoginUser(request)==null){
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        return ResultUtils.success(userService.userLogout(request));

    }

}
