package com.axue.framework.sdk.message.response;

import com.axue.framework.sdk.core.common.AcsResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 新增自定义消息返回数据格式
 *
 * @author axue
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AddCustomMessageResponse extends AcsResponse {

    private String returnCode;

    private String returnMsg;

    private Data data;

    @Getter
    @Setter
    public static class Data {

        private String id;

        private String name;

    }

}