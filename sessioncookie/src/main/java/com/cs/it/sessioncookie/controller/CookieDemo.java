package com.cs.it.sessioncookie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/25 15:20
 */

/**
 * Set-Cookie  服务器响应给客户端 客户端获取响应头获取Cookie信息
 *
 * Cookie 不能跨浏览器
 *
 * 关闭浏览器 在用 此浏览器 打开 拿不到cookie了
 *
 *
 * 局限性  1 只能存放 字符串类型
 *        2 只能存非中文
 *        3 1哥cookie得容量不能超过4kb
 */
@RestController
@RequestMapping("/cookie")
public class CookieDemo {
    private String COOKIE_KEY_LAST_TIME = "COOKIE_KEY_LAST_TIME";
    /**
     * 返回cookie
     * @param request
     * @param response
     */
    @RequestMapping("/to")
    public void cookie(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("userName","123456");
        //如果是负数浏览器关闭就失效 如果是正数 以秒为单位进行保存
        cookie.setMaxAge(60*60*24);//cookie保存一天 不可能永久保存
        response.addCookie(cookie);
        //response.setHeader();
        System.out.println("创建cookie成功");
    }


    /**
     * 获取cookie
     * @param request
     * @param response
     */
    @RequestMapping("/get")
    public void getCokie(HttpServletRequest request, HttpServletResponse response){
        //获取所有得cookie
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "-----------" + cookie.getValue());
            }
        }else{
            System.out.println("没有任何cookie信息");
        }
    }

    /**
     * 获取上次用户登陆时间
     * @param request
     * @param response
     */
    @RequestMapping("/getTimeLast")
    public void getTimeLast(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取cookie信息
        //2.如果cookie 中没有数据得话 说明是第一次访问  有数据的话 获取上一次cookie值
        //3.现在访问的登陆时间 存放在cookie中
        String lastTime = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                String cookieKey = cookie.getName();
                if(cookieKey.equals(COOKIE_KEY_LAST_TIME)){
                    lastTime = cookie.getValue();
                    break;
                }
            }
        }
        if(lastTime == null){
            response.getWriter().write("第一次访问");
        }else{
            response.getWriter().write("上次访问时间是:" + lastTime);
        }
        String currenttime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date());
        Cookie cookie = new Cookie(COOKIE_KEY_LAST_TIME,currenttime);
        cookie.setMaxAge(60*60*24*365);
        response.addCookie(cookie);
    }
}
