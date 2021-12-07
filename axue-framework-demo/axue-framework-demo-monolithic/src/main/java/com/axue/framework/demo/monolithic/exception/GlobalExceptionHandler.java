package com.axue.framework.demo.monolithic.exception;

import com.axue.framework.common.result.Result;
import com.axue.framework.common.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author axue
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<?> ProcessException(Exception e) {
        return Result.failure(ResultCodeEnum.FAILURE, e.getMessage());
    }

}
