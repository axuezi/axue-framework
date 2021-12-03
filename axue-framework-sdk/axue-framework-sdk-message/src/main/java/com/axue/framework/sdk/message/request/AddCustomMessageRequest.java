package com.axue.framework.sdk.message.request;

import cn.hutool.http.ContentType;
import com.axue.framework.sdk.core.common.AbstractAcsRequest;
import com.axue.framework.sdk.core.enums.MethodType;
import com.axue.framework.sdk.message.param.AddCustomMessageParam;
import com.axue.framework.sdk.message.response.AddCustomMessageResponse;

/**
 * 新增自定义消息请求封装
 *
 * @author axue
 */
public class AddCustomMessageRequest extends AbstractAcsRequest<AddCustomMessageResponse> {

    private static final String API = "/ability/message/customMessage/add";

    public AddCustomMessageRequest(AddCustomMessageParam param) {
        super(param);
    }

    @Override
    public String getRequestApi() {
        return API;
    }

    @Override
    public MethodType getMethod() {
        return MethodType.POST;
    }

    @Override
    public String getContentType() {
        return ContentType.JSON.getValue();
    }

    @Override
    public Class<AddCustomMessageResponse> getResponseClass() {
        return AddCustomMessageResponse.class;
    }

}
