package com.cs.it.sessioncookie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/25 15:20
 */
@Controller("/cookie")
public class CookieDemo {
    @RequestMapping("/test")
    public void cookie(HttpServletRequest request, HttpServletResponse response){
        System.out.println("111111111111111111");
    }
}
