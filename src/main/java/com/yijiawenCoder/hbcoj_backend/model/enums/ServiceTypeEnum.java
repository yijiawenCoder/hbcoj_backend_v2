package com.yijiawenCoder.hbcoj_backend.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户角色枚举
 *
# @author <a href="https://github.com/yijiawenCoder">yijiawenCoder</a>
 */
public enum ServiceTypeEnum {

    USER("用户", 0),
    QUESTION("题目", 1),
    COMMENT("评论", 2),
    POST("帖子", -1);

    private final String serviceId;

    private final Integer value;

    ServiceTypeEnum(String serviceId, Integer value) {
        this.serviceId = serviceId;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static ServiceTypeEnum getEnumByValue(Integer value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (ServiceTypeEnum anEnum : ServiceTypeEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public Integer getValue() {
        return value;
    }

    public String getServiceId() {
        return serviceId;
    }
}
