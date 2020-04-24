package com.cs.redis.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2020/4/24 11:03
 */
@RestController
public class JRedisApi {
   /* private static Jedis jedis = null;
    public static void main(String[] args) {
        jedis = new Jedis("106.13.130.241",6379);
        jedis.auth("74826421");//加入这一段代码
        jedis.ping();
        //jRedis();
        //jRedisMap();
        //jRedisList();
        jRedisSet();
    }
    public static void jRedis(){
        jedis.set("崔帅","27");
    }

    public static void jRedisMap(){
        Map<String,String> map = new HashMap<>();
        map.put("user1","张三0");
        map.put("user2","张三1");
        map.put("user3","张三2");
        jedis.hmset("mapkey",map);

    }
    public static void jRedisList(){
        jedis.lpush("listkey","1");
        jedis.lpush("listkey","2");
        jedis.lpush("listkey","3");
        jedis.lpush("listkey","4");
    }

    public static void jRedisSet(){
        jedis.sadd("set","redis1");
        jedis.sadd("set","redis2");

    }
    public static void jRediszSet(){

    }*/
}
