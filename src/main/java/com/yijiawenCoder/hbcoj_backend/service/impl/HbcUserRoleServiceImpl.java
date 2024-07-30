package com.yijiawenCoder.hbcoj_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yijiawenCoder.hbcoj_backend.common.ErrorCode;
import com.yijiawenCoder.hbcoj_backend.exception.BusinessException;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcUserRole;
import com.yijiawenCoder.hbcoj_backend.service.HbcUserRoleService;
import com.yijiawenCoder.hbcoj_backend.mapper.HbcUserRoleMapper;
import com.yijiawenCoder.hbcoj_backend.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 26510
 * @description 针对表【hbc_user_role(用户角色表)】的数据库操作Service实现
 * @createDate 2024-07-21 14:40:42
 */
@Service
public class HbcUserRoleServiceImpl extends ServiceImpl<HbcUserRoleMapper, HbcUserRole>
        implements HbcUserRoleService {

    @Override
    public PageUtils findSysRoleByPage(Map<String, Object> params) {
        return null;
    }

    @Override
    public List<HbcUserRole> findSysRoleAll() {
        return null;
    }

    /**
     *根据id查用户权限
     * @param userId
     * @return
     */
    @Override
    public List<HbcUserRole> findSysRoleByUserId(String userId) {
       /* if (userId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);

        }

        QueryWrapper<HbcUserRole> queryWrapper = new QueryWrapper<HbcUserRole>();
        queryWrapper
                .eq("user_id", userId);
        return list(queryWrapper);*/
        return null;
    }

    @Override
    public HbcUserRole findSysRoleByRoleId(String id) {
        return null;
    }

    @Override
    public void addSysRole(HbcUserRole sysRole) {

    }

    @Override
    public void delSysRoleById(String[] ids) {

    }

    @Override
    public void updateSysRole(HbcUserRole sysRole) {

    }
}




