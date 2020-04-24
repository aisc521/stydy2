package com.cs.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2020/4/24 11:31
 */
@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @SuppressWarnings("rawtypes")
    @Autowired
    private RedisTemplate redisTemplate;



    public void setString(String key,Object oj){
        set(key,oj,null);
    }
    public void setString(String key,Object oj,Long timeout){
        set(key,oj,timeout);
    }
    /**
     * @param key
     * @param oj
     * @param timeout 过期时间-秒
     */
    public void set(String key,Object oj,Long timeout){
        if(oj == null){
            return;
        }
        if(oj instanceof String){
            stringRedisTemplate.opsForValue().set(key, String.valueOf(oj));
            if(timeout != null){
                stringRedisTemplate.expire(key,timeout, TimeUnit.SECONDS);
            }
        }

    }
    public Object getString(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
