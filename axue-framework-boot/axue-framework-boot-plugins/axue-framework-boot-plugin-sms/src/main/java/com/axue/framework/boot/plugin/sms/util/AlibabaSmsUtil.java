package com.axue.framework.boot.plugin.sms.util;

import com.aliyun.dysmsapi20170525.*;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.models.*;
import com.axue.framework.boot.plugin.sms.entity.SmsConfig;

/**
 * 阿里云短信服务工具类
 *
 * @author axue
 */
public class AlibabaSmsUtil {

    /**
     * 发送短信
     *
     * @param phone        必填:待发送手机号
     * @param templateCode 必填:短信模板-可在短信控制台中找到
     * @param content      模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
     * @throws Exception Exception
     */
    public static SendSmsResponse sendSms(SmsConfig smsConfig, String phone, String templateCode, String content) throws Exception {
        return createClient(smsConfig)
                .sendSms(new SendSmsRequest()
                        .setPhoneNumbers(phone)
                        .setSignName(smsConfig.getSign())
                        .setTemplateCode(templateCode)
                        .setTemplateParam(content));
    }

    /**
     * 阿里云模板增加
     *
     * @param smsConfig       配置信息
     * @param remark          说明
     * @param templateName    模板名称
     * @param templateContent 模板内容
     * @param templateType    模板类型 0：验证码。1：短信通知。2：推广短信。3：国际/港澳台消息
     * @throws Exception Exception
     */
    public static AddSmsTemplateResponse addSmsTemplate(SmsConfig smsConfig, String remark, String templateName,
                                                        String templateContent, Integer templateType) throws Exception {
        return createClient(smsConfig)
                .addSmsTemplate(new AddSmsTemplateRequest()
                        .setRemark(remark)
                        .setTemplateName(templateName)
                        .setTemplateContent(templateContent)
                        .setTemplateType(templateType));
    }

    /**
     * 阿里云模板修改
     *
     * @param smsConfig       配置信息
     * @param templateCode    模板编号
     * @param remark          说明
     * @param templateName    模板名称
     * @param templateContent 模板内容
     * @param templateType    模板类型、验证码、推广短信等
     * @return ModifySmsTemplateResponse
     * @throws Exception Exception
     */
    public static ModifySmsTemplateResponse modifySmsTemplate(SmsConfig smsConfig, String templateCode, String remark,
                                                              String templateName, String templateContent, Integer templateType) throws Exception {
        return createClient(smsConfig)
                .modifySmsTemplate(new ModifySmsTemplateRequest()
                .setTemplateCode(templateCode)
                .setRemark(remark)
                .setTemplateName(templateName)
                .setTemplateContent(templateContent)
                .setTemplateType(templateType));
    }

    /**
     * 阿里云模板查询
     *
     * @param smsConfig    配置信息
     * @param templateCode 阿里云模板编码
     * @return QuerySmsTemplateResponse
     * @throws Exception Exception
     */
    public static QuerySmsTemplateResponse querySmsTemplate(SmsConfig smsConfig, String templateCode) throws Exception {
        return createClient(smsConfig)
                .querySmsTemplate(new QuerySmsTemplateRequest().setTemplateCode(templateCode));
    }

    /**
     * 阿里云模板删除
     *
     * @param smsConfig       配置信息
     * @param templateCode 阿里云模板编码
     * @return DeleteSmsTemplateResponse
     * @throws Exception Exception
     */
    public static DeleteSmsTemplateResponse deleteSmsTemplate(SmsConfig smsConfig, String templateCode) throws Exception {
        return createClient(smsConfig).deleteSmsTemplate(new DeleteSmsTemplateRequest().setTemplateCode(templateCode));
    }

    /**
     * 使用AK&SK初始化账号Client
     *
     */
    public static Client createClient(SmsConfig smsConfig) throws Exception {
        Config config = new Config().setAccessKeyId(smsConfig.getAccessKeyId())
                .setAccessKeySecret(smsConfig.getAccessKeySecret())
                .setEndpoint(smsConfig.getAccessUrl());
        return new Client(config);

    }

}
