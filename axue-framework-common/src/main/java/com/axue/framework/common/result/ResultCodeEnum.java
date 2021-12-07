package com.axue.framework.common.result;

/**
 * 状态码枚举
 *
 * @author axue
 */
public enum ResultCodeEnum {

    SUCCESS(200,"请求成功"),
    FAILURE(500, "请求失败");

    private final Integer code;

    private final String message;

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
