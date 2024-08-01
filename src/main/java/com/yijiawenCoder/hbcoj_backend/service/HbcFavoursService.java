package com.yijiawenCoder.hbcoj_backend.service;

import com.yijiawenCoder.hbcoj_backend.model.dto.favour.HbcFavourAddRequest;
import com.yijiawenCoder.hbcoj_backend.model.entity.HbcFavours;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yijiawenCoder.hbcoj_backend.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 26510
* @description 针对表【hbc_favours(收藏表)】的数据库操作Service
* @createDate 2024-07-21 14:40:17
*/
public interface HbcFavoursService extends IService<HbcFavours> {
boolean addFavour(HbcFavourAddRequest hbcFavourAddRequest, HttpServletRequest request);
boolean deleteFavour(HbcFavours hbcFavours, HttpServletRequest request);

List<QuestionVO> getFavourQuestionList(HttpServletRequest request);
}
