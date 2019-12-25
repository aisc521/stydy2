package com.cs.it.sessioncookie.controller;

/**
 * @Description 自定义缓存
 * @Author cuishuai
 * @Date 2019/12/25 16:38
 */


import com.cs.it.sessioncookie.utils.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 首先session 用map集合 装取数据
 * 其次用唯一不重复的字符串作为key 简称sessionId
 * Session有效期--怎么解决清除session操作：清除无非将map集合的数据清除掉 用定时的线程池
 */
@Controller
@RequestMapping("custom")
public class CustomCacheDemo {

    @RequestMapping("cookie")
    public void customCookie(HttpServletRequest request, HttpServletResponse response){
        CacheManager cacheManager = new CacheManager();
        cacheManager.put("cuishuai","123");
        System.out.println("保存成功");
        //开启一个线程定期刷新
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                cacheManager.checkValidityData();
            }
        }, 5000, TimeUnit.MILLISECONDS);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }

        String userName = (String)cacheManager.get("cuishuai");
        System.out.println("userName:" + userName);
        //在开启一个线程验证有效期
    }

    @RequestMapping("session")
    public void customSession(HttpServletRequest request, HttpServletResponse response){


    }
}
