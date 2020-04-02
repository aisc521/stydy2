package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot的作用
 * 优点：
 * 1.简化xml
 * 2.独立的应用程序
 * 3.单独war  不需要集成tomcat插件运行（内嵌一个tomcat）
 * 4.简化maven配置
 *
 */
@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}

