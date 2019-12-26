package com.cs.it.sessioncookie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/26 9:16
 */
@Controller
@RequestMapping("filter")
public class FilterDemoRequestDemo {
    @RequestMapping("/request")
    public void filterRequest(HttpServletRequest request, HttpServletResponse response){
        System.out.println("filter====请求..............");
    }
}
