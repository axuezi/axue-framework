package com.axue.framework.sdk.core.common;

import lombok.Data;

@Data
public class Credential {

    private String appKey;

    private String appSecret;

    public Credential() {
    }

    public Credential(String appKey, String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

}
