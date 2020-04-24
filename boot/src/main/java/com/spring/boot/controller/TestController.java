package com.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2020/4/22 9:13
 */

/**
 * @ResponseBody  返回json格式
 * @RestController = @Controller + @ResponseBod
 *
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }

    /**
     * 异常捕获
     * @return
     */
    @RequestMapping("/hello1")
    public String hello1(){
        int i = 1 / 0;
        return "success1";
    }

}
