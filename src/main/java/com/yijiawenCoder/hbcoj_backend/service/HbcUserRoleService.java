package com.yijiawenCoder.hbcoj_backend.service;

import com.yijiawenCoder.hbcoj_backend.model.entity.HbcUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yijiawenCoder.hbcoj_backend.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
* @author 26510
* @description 针对表【hbc_user_role(用户角色表)】的数据库操作Service
* @createDate 2024-07-21 14:40:42
*/
public interface HbcUserRoleService extends IService<HbcUserRole> {

    PageUtils findSysRoleByPage(Map<String, Object> params);

    List<HbcUserRole> findSysRoleAll();

    List<HbcUserRole> findSysRoleByUserId(String id);

    HbcUserRole findSysRoleByRoleId(String id);

    void addSysRole(HbcUserRole sysRole);

    void delSysRoleById(String[] ids);

    void updateSysRole(HbcUserRole sysRole);

}
