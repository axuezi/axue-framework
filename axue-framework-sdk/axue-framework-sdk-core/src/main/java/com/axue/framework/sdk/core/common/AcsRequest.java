package com.axue.framework.sdk.core.common;

import com.axue.framework.sdk.core.enums.MethodType;

import java.util.Map;

public interface AcsRequest<T> {

    /**
     * 获取请求地址
     */
    String getRequestApi();

    /**
     * 获取请求方式
     */
    MethodType getMethod();

    /**
     * 获取参数
     */
    Map<String, Object> getParamMap();

    /**
     * 获取请求头内容
     */
    Map<String, String> getHeaderMap();

    /**
     * 获取传参类型
     */
    String getContentType();

    /**
     * 获取Token
     */
    String getToken();

    /**
     * 获取响应类型
     */
    Class<T> getResponseClass();

}
