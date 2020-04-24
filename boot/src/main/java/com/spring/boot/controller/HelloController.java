package com.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2020/4/22 15:01
 */

/**
 *
 */
@RestController
public class HelloController {

    @RequestMapping("hello2")
    public String hello2(){
        return "hello2";
    }
}
