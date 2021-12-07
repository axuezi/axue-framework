package com.axue.framework.boot.plugin.sms.entity;


import lombok.Data;


/**
 * 短信模板参数
 *
 * @author axue
 */
@Data
public class SmsTemplateParam {

    /**
     * 模板id，新增完成之后返回
     */
    private String templateCode;

    /**
     * 短信平台 1:阿里云 2:腾讯云
     */
    private Integer smsPlatform;

    /**
     * 模板类型 1:短信通知 2:验证码 3:推广短信
     */
    private Integer templateType;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 模板内容
     */
    private String templateContent;

    /**
     * 模板说明、用途、使用场景说明之类
     */
    private String remark;

}
