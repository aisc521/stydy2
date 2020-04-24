package com.spring.boot.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 异常信息捕获
 * @Author cuishuai
 * @Date 2020/4/22 15:18
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody //拦截返回是json返回结果
    public Map<String,Object>  exceptionHandler(){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code","500");
        result.put("msg","亲，系统错误请稍后重试");
        return result;
    }
}
