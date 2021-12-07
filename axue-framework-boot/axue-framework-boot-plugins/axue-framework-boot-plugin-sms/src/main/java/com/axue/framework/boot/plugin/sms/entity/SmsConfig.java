package com.axue.framework.boot.plugin.sms.entity;


import lombok.Data;

/**
 * 短信平台配置
 *
 * @author axue
 */
@Data
public class SmsConfig  {

    /**
     * 短信平台: 1:阿里云,2:腾讯云
     */
    private Integer platformId;

    /**
     * 签名阿里云名称，钉钉为AgentId
     */
    private String sign;

    /**
     * AccessKey
     */
    private String accessKeyId;

    /**
     * 秘钥
     */
    private String accessKeySecret;

    /**
     * 访问域名
     */
    private String accessUrl;

}
