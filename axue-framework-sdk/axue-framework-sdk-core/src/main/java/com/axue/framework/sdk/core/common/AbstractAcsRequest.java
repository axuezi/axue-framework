package com.axue.framework.sdk.core.common;

import cn.hutool.http.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAcsRequest<T extends AcsResponse> implements AcsRequest {

    private String token;

    protected Map<String, String> headerMap;

    protected Map<String, Object> paramsMap;

    public AbstractAcsRequest() {
        this.headerMap = new HashMap<>();
        this.paramsMap = new HashMap<>();
    }

    public AbstractAcsRequest(Object object) {
        this("", object);
    }

    public AbstractAcsRequest(String token, Object object) {
        this(token, new HashMap<>(), object);
    }

    public AbstractAcsRequest(Map<String, String> headerMap, Object object) {
        this("", headerMap, object);
    }

    public AbstractAcsRequest(String token, Map<String, String> headerMap, Object object) {
        this.headerMap = new HashMap<>();
        this.paramsMap = JSONObject.parseObject(JSON.toJSONString(object));
        this.token = token;
        if (null != headerMap && !headerMap.isEmpty()) {
            this.headerMap.putAll(headerMap);
        }
    }

    @Override
    public Map<String, String> getHeaderMap() {
        return this.headerMap;
    }

    @Override
    public String getContentType() {
        return ContentType.JSON.getValue();
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public Map<String, Object> getParamMap() {
        return this.paramsMap;
    }

    @Override
    public abstract Class<T> getResponseClass() ;

}