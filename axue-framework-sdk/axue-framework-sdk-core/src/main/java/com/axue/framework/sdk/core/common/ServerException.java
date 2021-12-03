package com.axue.framework.sdk.core.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ServerException extends Exception {

    private static final long serialVersionUID = -7345371390798165336L;

    private int errCode;

    private String errMsg;

    public ServerException(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

}
