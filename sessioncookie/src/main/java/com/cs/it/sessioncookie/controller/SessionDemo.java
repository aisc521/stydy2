package com.cs.it.sessioncookie.controller;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/25 16:02
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * session 底层实现原理：服务器端创建了一个session之后 会在响应里面将  （session值存放在服务器端）sessionId返回给客户端 ，客户端将sessionId保存在本地硬盘，在次请求得时候 将sessionId
 * 通过请求头得方式传给服务端 ----App登陆
 *
 * 服务器端创建完session  会将sessionId 通过请求头方式返回给 客户端
 *
 * 关闭浏览器 session 会失效吗  不会失效 session 是存放服务器端  只要session 没有达到失效  关闭浏览器 只是sessionId 失效了 但session 没有失效
 *
 */
@Controller
@RequestMapping("/session")
public class SessionDemo {

    @RequestMapping("add")
    public void addSession(HttpServletRequest request, HttpServletResponse response){
        //默认是true 表示如果没有session  就会创建一个session  如果false 没有没有找到session 就不会创建一个session
        HttpSession session = request.getSession();
        session.setAttribute("userName","崔帅");
    }
    @RequestMapping("get")
    public void getSession(HttpServletRequest request, HttpServletResponse response){
        //默认是true 表示如果没有session  就会创建一个session  如果false 没有没有找到session 就不会创建一个session
        HttpSession session = request.getSession(false);
        if(session != null){
            String userName = (String) session.getAttribute("userName");
            System.out.println("userName:" + userName);
        }else{
            System.out.println("没有找到任何结果=================================");
        }

    }
}
