package com.cs.it.base.spring.controller;

import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/30 10:12
 */

@Component
public class Aop {
    /**
     * 开启事务
     */
    public void begin(){
        System.out.printf("开启事务");
    }

    /**
     * 提交事务
     */
    public void commit(){
        System.out.printf("提交事务");
    }

}
