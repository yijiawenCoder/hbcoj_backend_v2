package com.yijiawenCoder.hbcoj_backend.service;

import com.yijiawenCoder.hbcoj_backend.model.dto.UserRegisterRequest;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcUsers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yijiawenCoder.hbcoj_backend.model.vo.LoginUserVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 26510
* @description 针对表【hbc_users(用户表)】的数据库操作Service
* @createDate 2024-07-21 14:40:45
*/
public interface HbcUsersService extends IService<HbcUsers> {

    String userRegister(UserRegisterRequest userRegisterRequest);



    String deleteUser(HbcUsers hbcUsers, HttpServletRequest request);

    String updateUser(HbcUsers hbcUsers, HttpServletRequest request);

    boolean isAdmin(HttpServletRequest request);
    boolean isAdmin(HbcUsers user);

    LoginUserVO userLogin(String userAccount, String userPassword,HttpServletRequest request);

    LoginUserVO  getLoginUserVO(HbcUsers user);

}
