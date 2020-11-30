package com.example.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @date 2020/7/22上午11:53
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @ExceptionHandler需要指明处理哪个异常，否则会报错：No exception types mapped to public void com.example.exception.GlobalExceptionHandler.handleException()
     */
    @ExceptionHandler(Exception.class)
    public void handleException() {
        log.error("系统异常");
    }

}
