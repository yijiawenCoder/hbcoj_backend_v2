package com.yijiawenCoder.hbcoj_backend.service.impl;

import java.util.Date;
import java.util.UUID;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yijiawenCoder.hbcoj_backend.common.ErrorCode;
import com.yijiawenCoder.hbcoj_backend.exception.BusinessException;
import com.yijiawenCoder.hbcoj_backend.model.dto.UserRegisterRequest;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcUsers;
import com.yijiawenCoder.hbcoj_backend.model.enums.UserRoleEnum;
import com.yijiawenCoder.hbcoj_backend.model.vo.LoginUserVO;
import com.yijiawenCoder.hbcoj_backend.service.HbcUsersService;
import com.yijiawenCoder.hbcoj_backend.mapper.HbcUsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;

import static com.yijiawenCoder.hbcoj_backend.constant.UserConstant.USER_LOGIN_STATE;

/**
 * @author 26510
 * @description 针对表【hbc_users(用户表)】的数据库操作Service实现
 * @createDate 2024-07-21 14:40:45
 */
@Service
@Slf4j
public class HbcUsersServiceImpl extends ServiceImpl<HbcUsersMapper, HbcUsers>
        implements HbcUsersService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public String userRegister(UserRegisterRequest userRegisterRequest) {

        if (userRegisterRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
        if (userAccount.length() < 6) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户账号过短");
        }
        if (userPassword.length() < 6 || checkPassword.length() < 6) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户密码过短");

        }
        if (!userPassword.equals(checkPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "两次输入的密码不一致");

        }
//userAccount.intern()检查字符串池中是否有该字符串
        synchronized (userAccount.intern()) {
            QueryWrapper<HbcUsers> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_account", userAccount);
            long count = this.count(queryWrapper);
            if (count > 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号重复");

            }


            HbcUsers user = new HbcUsers();
            user.setUserId("USERS:" + new Date().getTime() + ":" + UUID.randomUUID());
            user.setUserName(userRegisterRequest.getUserName());
            user.setUserAccount(userAccount);
            user.setUserPassword(passwordEncoder.encode(userPassword));
            user.setUserAvatar(userRegisterRequest.getUserAvatar());
            user.setUserProfile(userRegisterRequest.getUserProfile());
            user.setUserRole("user");
            user.setCreateTime(new Timestamp(new java.util.Date().getTime()));
            user.setUpdateTime(new Timestamp(new java.util.Date().getTime()));
            user.setIsDelete(0);
            user.setUserState(0);

            int insert = this.baseMapper.insert(user);
            if (insert <= 0) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }

            return user.getUserId();
        }


    }

    @Override
    public String deleteUser(HbcUsers hbcUsers, HttpServletRequest request) {
        if (isAdmin(request)) {
            int row = this.baseMapper.deleteById(hbcUsers.getUserId());
            if (row <= 0) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
            }
            return "" + row;
        } else {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }

    }

    //TODO
    @Override
    public String updateUser(HbcUsers hbcUsers, HttpServletRequest request) {


        return null;
    }

    @Override
    public boolean isAdmin(HttpServletRequest request) {
        // 仅管理员可查询
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        HbcUsers user = (HbcUsers) userObj;
        return isAdmin(user);
    }

    @Override
    public boolean isAdmin(HbcUsers user) {
        return user != null && UserRoleEnum.ADMIN.getValue().equals(user.getUserRole());
    }

    @Override
    public LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        // 1. 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
        if (userAccount.length() < 4) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号错误");
        }
        if (userPassword.length() < 8) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "密码错误");
        }
        // 2. 加密

        // 查询用户是否存在
        QueryWrapper<HbcUsers> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account", userAccount);
        queryWrapper.eq("user_password", userPassword);
        HbcUsers user = this.baseMapper.selectOne(queryWrapper);
        // 用户不存在
        if (user == null) {
            log.info("user login failed, userAccount cannot match userPassword");
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户不存在或密码错误");
        }
        // 3. 记录用户的登录态
        request.getSession().setAttribute(USER_LOGIN_STATE, user);
        return this.getLoginUserVO(user);
    }

    @Override

    public LoginUserVO getLoginUserVO(HbcUsers user) {
        if (user == null) {
            return null;
        }
        LoginUserVO loginUserVO = new LoginUserVO();
        BeanUtils.copyProperties(user, loginUserVO);
        return loginUserVO;
    }


}




