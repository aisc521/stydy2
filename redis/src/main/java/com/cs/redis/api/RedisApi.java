package com.cs.redis.api;

import com.cs.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2020/4/24 10:16
 */

/**
 * resid 解决高并发
 * 高并发解决方案 第一种 就是使用缓存
 *
 * 内存数据库：非关系型数据库 （NOSQL） redis mongdb  等 不同之处在于存储数据格式不一样  mongdb 存json
 *
 *
 * redis 与 memcached 的区别
 * redis 可以 持久化 memcached 不能支持持久化  持久化 ---保存到硬盘上
 * redis 比 memcached 支持的数据类型更加丰富
 *
 * redis应用场景：减轻数据库的访问压力，  session共享解决方案，   登录忘记密码发送短信验证码 验证码的有效期存放在redis中或者在session中
 *
 * redis 支持事务
 *
 * redis 主从复制：
 * 什么是redis的主从复制----读写分离
 * 提高性能 高可用   哨兵机制
 * 子redis  修改  redis.config 配置文件 ----slaveof 主ip地址 + 端口号 有密码 下面设置密码
 * 主从同步的时候  服务器 ip 一定要在同一个网络上 要通
 *
 *哨兵机制（心跳）：解决redis 高可用问题
 * 什么是哨兵机制---哨兵 单独的应用程序 老大挂了 重新选举
 * 修改配置文件
 *
 *
 * redis事务：
 * redis支持事务
 * multi 开始一个事务 EXEC 提交当前事务
 *
 *redis持久化：
 * 就是将内存内存中的内容通过序列化  的方式 保存在硬盘上
 * redis 怎么做持久化：
 * rdb：以数据的方式进行保存备份
 * aof：以日志形式进行保存备份  get查询不会保存
 * redis 默认用的 rdb存储方式
 * redis.config  修改 save 下的配置信息  默认开启
 *
 * aof：默认不开启
 * 修改配置：appendonly 改成yes  等
 * 只存储写 不存储读
 *
 * 什么是 发布订阅   ---发布消息
 *
 *
 */
@RestController
public class RedisApi {
    @Autowired
    private RedisService redisService;

    @RequestMapping("/setRedis")
    public String setToken(String value){
        String tokenKey = UUID.randomUUID() + "";
        redisService.setString(tokenKey,value,20L);
        return tokenKey;
    }
    @RequestMapping("/getRedis")
    public String getToken(String key){
        System.out.println((String) redisService.getString(key));
        return (String) redisService.getString(key);
    }
}
