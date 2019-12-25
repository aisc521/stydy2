package com.cs.it.sessioncookie.utils;

import com.cs.it.sessioncookie.entity.Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 提供缓存的api
 * @Author cuishuai
 * @Date 2019/12/25 16:44
 */
public class CacheManager {
    //存放缓存数据
    private Map<String,Cache> caCheMap = new HashMap<String,Cache>();

    /**
     * 放入缓存
     * @param key
     * @param value
     */

    public synchronized void put(String key,Object value){
        Cache cache = new Cache();
        cache.setKey(key);
        cache.setValue(value);

        caCheMap.put(key,cache);
    }

    public synchronized void put(String key,Object value,Long timeout){
        Cache cache = new Cache();
        cache.setKey(key);
        cache.setValue(value);
        if(timeout != null){
            //保存毫秒数
            cache.setTimeout(System.currentTimeMillis() + timeout);
        }
        caCheMap.put(key,cache);
    }

    /**
     * 删除api
     * @param key
     */
    public synchronized void del(String key){
        caCheMap.remove(key);
    }

    /**
     * 移除
     * @param key
     */
    public synchronized void remove(String key){
        System.out.println("删除成功");
        caCheMap.remove(key);
    }


    /**
     * 获取
     * @param key
     * @return
     */
    public synchronized Object get(String key){
        Cache cache = caCheMap.get(key);
        if(cache != null){
            return cache.getValue();
        }
        return null;
    }

    /**
     * 定时检车删除有效期的值
     */
    public synchronized void checkValidityData() {
        for (String key : caCheMap.keySet()) {
            Cache cache = caCheMap.get(key);
            if (cache == null) {
                break;
            }
            Long timeout = cache.getTimeout();
            Long currentTime = System.currentTimeMillis();
            // 说明 已经过期。
            if ((currentTime - timeout) > 0) {
                remove(key);
            }
        }
    }


}
