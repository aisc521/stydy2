package com.cs.it.sessioncookie.controller;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/26 9:09
 */


import com.cs.it.sessioncookie.utils.XssAndSplHttpServletWrapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 什么是  Filter 在Servlet中 相当于是一个过滤器  任何请求 都会先交给过滤器去拦截 登录  XSS攻击 权限
 * springmvc struts 拦截器 通过过滤器进行包装的
 */
@Component
public class FilterDemo implements Filter{

    /**
     * 证明是否是单例的 就看无参构造函数 是否只执行一次
     * 注意共享全局变量 线程安全
     */
    public FilterDemo(){
        System.out.println("无参构造构造函数执行");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化方法");
    }

    /**
     * 如果 doFilter 不执行  不放行 那么就不往下执行
     * @param request
     * @param response
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("正常的拦截请求....");
        HttpServletRequest req = (HttpServletRequest) request;
        XssAndSplHttpServletWrapper xssRequestWarpper = new XssAndSplHttpServletWrapper(req);
        filterChain.doFilter(xssRequestWarpper,response);
    }

    /**
     * 只执行一次
     */
    @Override
    public void destroy() {
        System.out.println("销毁请求.....");
    }
}
