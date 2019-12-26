package com.cs.it.http.controller;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/26 10:00
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 什么是http协议：客户端与服务端 进行传输格式 简称超文本传输协议  基于 socket tcp协议的
 * html  json  text 流 ======  二进制传输
 *
 *
 * http无状态协议
 * 无事务管理
 *
 *
 *
 *格式分类
 * 请求：httpServletRequest
 * 请求行
 * 请求头
 * 请求内容
 * 请求体（只能在post请求）
 *
 *
 *
 * 响应：httpServletResponse
 * 响应行
 * 响应内容
 * 响应体（html内容）
 *
 *
 * 304从本地缓存中读取的
 * 302重定向
 * 404 找不到页面
 * 500 服务器请求错误
 */


@Controller
@RequestMapping("/http")
public class Http {

    /**
     * 跳转时间戳页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/toHtml")
    public String toTimeStampHtml(HttpServletRequest request, HttpServletResponse response){
        return "toTimeStamp";
    }


    /**
     * 防盗链 页面跳转 防止非法盗用链接
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/toPreventHtml")
    public String preventChainStealing(HttpServletRequest request, HttpServletResponse response){
        return "toPrevent";
    }

    /**
     * 重定向实现原理
     * 响应头返回状态码为302  Location客户端收到状态码为302  本地帮你跳转到Location 重定向一般 用在外部服务器
     */

    /**
     * http和https
     * https 要到ca申请证书
     * http超文本传输协议 明文传输 80
     * https ssl加密传输协议 + 证书  加密传输 443  握手耗费时间加载时间长
     *
     */
}
































