package com.axue.framework.sdk.core.common;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.axue.framework.sdk.core.enums.MethodType;
import com.axue.framework.sdk.core.util.RsaUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
public class DefaultProfile {


    private URI endPoint;

    private Credential credential;

    private HttpClientConfig configuration;

    private static boolean isParamEncrypt = false;

    private static DefaultProfile defaultProfile;

    public DefaultProfile(String endpoint) {
        this(endpoint, new Credential(null, null), isParamEncrypt, new HttpClientConfig());
    }

    public DefaultProfile(String endpoint, String appKey, String appSecret) {
        this(endpoint, new Credential(appKey, appSecret), isParamEncrypt, new HttpClientConfig());
    }

    public DefaultProfile(String endpoint, String appKey, String appSecret, Boolean isParamEncrypt) {
        this(endpoint, new Credential(appKey, appSecret), isParamEncrypt, new HttpClientConfig());
    }

    public DefaultProfile(String endpoint, Credential credential, Boolean isParamEncrypt, HttpClientConfig config) {
        this.setEndPoint(endpoint);
        this.credential = credential;
        this.configuration = config;
        DefaultProfile.isParamEncrypt = isParamEncrypt;
        defaultProfile = this;
    }

    private void setEndPoint(String endpoint) {
        this.endPoint = this.toUrl(endpoint);
    }

    private synchronized URI toUrl(String endpoint) {
        if (!endpoint.contains("://")) {
            endpoint = "http://" + endpoint;
        }
        try {
            return new URI(endpoint);
        } catch (URISyntaxException var3) {
            throw new IllegalArgumentException(var3);
        }
    }

    private Map<String, String> builderHeader(AbstractAcsRequest request) {
        Map<String, String> headers = request.getHeaderMap();
        Map<String, String> headerMap = new HashMap<>(16);
        headerMap.put("Authorization", request.getToken());
        headerMap.put("accessToken", request.getToken());
        headerMap.put("user-agent", "axue-sdk-core/1.0.1");
        headerMap.put("accept", request.getContentType());
        headerMap.put("content-type", request.getContentType());
        headerMap.put("date", System.currentTimeMillis() + "");
        if (null != headers && !headers.isEmpty()) {
            for (Map.Entry<String, String> stringStringEntry : headers.entrySet()) {
                String value = stringStringEntry.getValue();
                if (null != value && !value.isEmpty()) {
                    headerMap.put(stringStringEntry.getKey(), value);
                }
            }
        }
        return headerMap;
    }

    public <T extends AcsResponse> T getAcsResponse(AbstractAcsRequest<T> request) throws ServerException {
        Map<String, Object> paramsMap = request.getParamMap();
        Map<String, String> headerMap = this.builderHeader(request);
        String appKey = this.credential.getAppKey();
        String appSecret = this.credential.getAppSecret();
        String api = request.getRequestApi();
        api = api.startsWith("/") ? api : "/" + api;
        String url = this.endPoint.toString() + api;
        HttpResponse response = null;
        String body = JSONObject.toJSONString(paramsMap);
        if (isParamEncrypt) {
            // 加密
            try {
                body = RsaUtil.encrypt(body, appSecret);
            } catch (Exception e) {
                System.out.println("加密失败:" + body);
                e.printStackTrace();
            }
        }
        MethodType method = request.getMethod();
        log.info("requestUrl:{} \n,token:{}\n,param:{}\n",url,request.getToken(),body);
        if (method.equals(MethodType.GET)) {
            response = HttpRequest.get(url).headerMap(headerMap, false).execute();
        } else if (method.equals(MethodType.POST)) {
            response = HttpRequest.post(url).headerMap(headerMap, false).body(String.valueOf(JSONUtil.parseObj(body))).execute();
        } else {
            if (!method.equals(MethodType.OPTIONS)) {
                throw new IllegalArgumentException("暂不支持[\"" + method.name() + "\"]请求！");
            }
        }
        assert response != null;
        if (!response.isOk()) {
            throw new ServerException(response.getStatus(), response.body());
        }
        log.info(response.body());
        return JSONObject.parseObject(response.body(), request.getResponseClass());
    }

}
