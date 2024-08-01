package com.yijiawenCoder.hbcoj_backend.model.dto.favour;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class HbcFavourAddRequest implements Serializable {

    /**
     * 业务id
     */
    private String serviceId;

    /**
     * 业务类型
     */
    private Integer serviceType;

    /**
     * 收藏关联收藏的用户id
     */
    private String userId;


    private static final long serialVersionUID = 1L;
}
