package com.axue.framework.boot.plugin.sms.util;

import com.axue.framework.boot.plugin.sms.entity.SmsConfig;
import com.axue.framework.boot.plugin.sms.entity.SmsTemplateParam;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 腾讯云短信服务工具类
 *
 * @author axue
 */
@Slf4j
public class TencentSmsUtil {

    /**
     * 使用AK&SK初始化账号Client
     */
    public static SmsClient createClient(SmsConfig smsConfig) {
        Credential cred = new Credential(smsConfig.getAccessKeyId(), smsConfig.getAccessKeySecret());
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(smsConfig.getAccessUrl());
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        return new SmsClient(cred, "", clientProfile);
    }

    /**
     * 腾讯云短信发送
     *
     * @param smsConfig    短信配置
     * @param phone        手机号
     * @param templateCode 模板ID
     * @param content      内容
     * @return 发送结果
     * @throws TencentCloudSDKException TencentCloudSDKException
     */
    public static SendSmsResponse sendSms(SmsConfig smsConfig, String phone, String templateCode, String content) throws TencentCloudSDKException {
        SendSmsRequest req = new SendSmsRequest();
        String[] phones = Stream.of(phone.split(",")).toArray(String[]::new);
        req.setPhoneNumberSet(phones);
        req.setTemplateID(templateCode);
        // TODO 需要更改
        req.setSmsSdkAppid("sssssss");
        String[] contents = Stream.of(content.split(",")).toArray(String[]::new);
        req.setTemplateParamSet(contents);
        return createClient(smsConfig).SendSms(req);
    }

    /**
     * 新增短信模板
     *
     * @param smsConfig 配置
     * @return AddSmsTemplateResponse
     * @throws TencentCloudSDKException TencentCloudSDKException
     */
    public static AddSmsTemplateResponse addSmsTemplate(SmsConfig smsConfig, SmsTemplateParam dto) throws TencentCloudSDKException {
        AddSmsTemplateRequest req = new AddSmsTemplateRequest();
        // 模板名称
        req.setTemplateName(dto.getTemplateName());
        // 模板内容
        req.setTemplateContent(dto.getTemplateContent());
        // 短信类型，0表示普通短信, 1表示营销短信
        req.setSmsType(Long.valueOf(dto.getTemplateType()));
        // 是否国际/港澳台短信 0：表示国内短信。1：表示国际/港澳台短信
        req.setInternational(0L);
        // 模板备注，例如申请原因，使用场景等。
        req.setRemark(dto.getRemark());
        return createClient(smsConfig).AddSmsTemplate(req);
    }

    /**
     * 修改短信模板
     *
     * @param smsConfig 配置
     * @return ModifySmsTemplateResponse
     * @throws TencentCloudSDKException TencentCloudSDKException
     */
    public static ModifySmsTemplateResponse modifySmsTemplate(SmsConfig smsConfig, SmsTemplateParam dto) throws TencentCloudSDKException {
        ModifySmsTemplateRequest req = new ModifySmsTemplateRequest();
        // 待修改的模板的模板 ID
        req.setTemplateId(Long.valueOf(dto.getTemplateCode()));
        // 模板名称
        req.setTemplateName(dto.getTemplateName());
        // 模板内容
        req.setTemplateContent(dto.getTemplateContent());
        // 短信类型，0表示普通短信, 1表示营销短信
        req.setSmsType(Long.valueOf(dto.getTemplateType()));
        // 是否国际/港澳台短信 0：表示国内短信。1：表示国际/港澳台短信
        req.setInternational(0L);
        // 模板备注，例如申请原因，使用场景等。
        req.setRemark(dto.getRemark());
        return createClient(smsConfig).ModifySmsTemplate(req);
    }

    /**
     * 短信模板查询
     *
     * @param smsConfig 配置
     * @return DescribeSmsTemplateListResponse
     * @throws TencentCloudSDKException TencentCloudSDKException
     */
    public static DescribeSmsTemplateListResponse describeSmsTemplateList(SmsConfig smsConfig, String templateCode) throws TencentCloudSDKException {
        DescribeSmsTemplateListRequest req = new DescribeSmsTemplateListRequest();
        // 模板 ID 数组
        Long[] templates = Arrays.stream(templateCode.split(",")).map(s -> Long.parseLong(s.trim())).toArray(Long[]::new);
        req.setTemplateIdSet(templates);
        // 是否国际/港澳台短信 0：表示国内短信。1：表示国际/港澳台短信
        req.setInternational(0L);
        return createClient(smsConfig).DescribeSmsTemplateList(req);
    }

    /**
     * 删除短信模板
     *
     * @param smsConfig 配置
     * @return DeleteSmsTemplateResponse
     * @throws TencentCloudSDKException TencentCloudSDKException
     */
    public static DeleteSmsTemplateResponse deleteSmsTemplate(SmsConfig smsConfig, String templateCode) throws TencentCloudSDKException {
        DeleteSmsTemplateRequest req = new DeleteSmsTemplateRequest();
        // 待删除的模板 ID
        req.setTemplateId(Long.valueOf(templateCode));
        return createClient(smsConfig).DeleteSmsTemplate(req);
    }

}
