package com.yijiawenCoder.hbcoj_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yijiawenCoder.hbcoj_backend.model.dto.favour.HbcFavourAddRequest;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcFavours;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcUsers;
import com.yijiawenCoder.hbcoj_backend.model.enums.DeleteStateEnum;
import com.yijiawenCoder.hbcoj_backend.model.vo.QuestionVO;
import com.yijiawenCoder.hbcoj_backend.service.HbcFavoursService;
import com.yijiawenCoder.hbcoj_backend.mapper.HbcFavoursMapper;
import com.yijiawenCoder.hbcoj_backend.service.HbcUsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author 26510
 * @description 针对表【hbc_favours(收藏表)】的数据库操作Service实现
 * @createDate 2024-07-21 14:40:17
 */
@Service
public class HbcFavoursServiceImpl extends ServiceImpl<HbcFavoursMapper, HbcFavours>
        implements HbcFavoursService {
    @Resource
    HbcUsersService usersService;

    @Override
    public boolean addFavour(HbcFavourAddRequest hbcFavourAddRequest, HttpServletRequest request) {
        HbcFavours favours = new HbcFavours();
        BeanUtils.copyProperties(hbcFavourAddRequest, favours);
        favours.setFavourId(hbcFavourAddRequest.getServiceId() + ":" + favours.getFavourId());
        favours.setCreateTime(new Timestamp(new java.util.Date().getTime()));
        favours.setUpdateTime(new Timestamp(new java.util.Date().getTime()));
        favours.setIsDelete(DeleteStateEnum.NORMAL.getValue());
       return this.save(favours);
    }

    @Override
    public boolean deleteFavour(HbcFavours hbcFavours, HttpServletRequest request) {
        hbcFavours.setIsDelete(DeleteStateEnum.DELETE.getValue());
        hbcFavours.setUpdateTime(new Timestamp(new java.util.Date().getTime()));
        return this.updateById(hbcFavours);
    }



    @Override
    public List<QuestionVO> getFavourQuestionList(HttpServletRequest request) {
        HbcUsers loginUser = usersService.getLoginUser(request);
        //TODO 查询用户收藏夹(联合查询
        return null;
    }
}





