package com.axue.framework.common.result;

import java.io.Serializable;

/**
 * 返回体类
 *
 * @param <T>
 * @author axue
 */
public class Result<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 返回成功
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.setCode(ResultCodeEnum.SUCCESS.code());
        result.setMessage(ResultCodeEnum.SUCCESS.message());
        return result;
    }

    /**
     * 返回成功 + 数据
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setCode(ResultCodeEnum.SUCCESS.code());
        result.setMessage(ResultCodeEnum.SUCCESS.message());
        result.setData(data);
        return result;
    }

    /**
     * 返回失败
     */
    public static <T> Result<T> failure(ResultCodeEnum codeEnum) {
        Result<T> result = new Result<T>();
        result.setCode(codeEnum.code());
        result.setMessage(codeEnum.message());
        return result;
    }

    /**
     * 返回失败（自定义状态，返回信息） + 数据
     */
    public static <T> Result<T> failure(Integer code, String message, T data) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 返回失败 + 数据
     */
    public static <T> Result<T> failure(ResultCodeEnum codeEnum, T data) {
        Result<T> result = new Result<T>();
        result.setCode(codeEnum.code());
        result.setMessage(codeEnum.message());
        result.setData(data);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}