package com.axue.framework.sdk.message.param;

import lombok.Data;

/**
 * 自定义消息只支持站内信和钉钉消息
 *
 * @author axue
 */
@Data
public class AddCustomMessageParam {

    /**
     * 发送类型，1站内信，2短信，3钉钉
     */
    public Integer sendType;

    /**
     * 接收人
     */
    public String[] personCodes;

    /**
     * 消息类型 message_type:personal:order_todo(个人消息-工单待办)，
     *        message_type:personal:order_timeout(个人消息-工单超时提醒)
     */
    public String subMessageType;

    /**
     * 自定义消息内容
     */
    public String content;

    /**
     * 租户编码
     */
    private String tenementCode;

}

