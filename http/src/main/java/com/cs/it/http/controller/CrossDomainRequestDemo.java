package com.cs.it.http.controller;

/**
 * @Description 跨域请求
 * @Author cuishuai
 * @Date 2019/12/26 14:09
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ajax类似于 java异步  多线程的 也可以设置为同步 async 局部刷新
 *
 *
 *
 * 跨域解决
 * 1.在响应头中设置运行跨域  简单
 * 2.jsonp 解决跨域 但是 只能是 发送get请求 很少使用
 * 3.搭建网关系统
 * 4.使用后台服务转发（使用少 不建议使用  占用宽带）
 */
@Controller
@RequestMapping("ajax")
public class CrossDomainRequestDemo {

    @RequestMapping("cross")
    public String ajax(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        return "crossDomainRequest";
    }
}
