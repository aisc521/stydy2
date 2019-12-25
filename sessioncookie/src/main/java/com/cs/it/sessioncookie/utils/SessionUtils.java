package com.cs.it.sessioncookie.utils;

/**
 * @Description TODO
 * @Author token 其实就是一个令牌 随机生成的 有效期的 类似于 sessionId
 * @Date 2019/12/25 17:13
 */
public class SessionUtils {
    private CacheManager cacheManager = new CacheManager();
    /**
     *
     * @methodDesc: 功能描述:(初始化cacheManager)
     * @author: 余胜军
     * @param:
     * @createTime:2017年9月2日 下午9:59:59
     * @returnType: void
     * @copyright:上海每特教育科技有限公司
     */
    public void init() {
        if (cacheManager != null) {
            cacheManager = new CacheManager();
        }
    }

    /**
     *
     * @methodDesc: 功能描述:(新增一个session，返回一个sessionId)
     * @param: @param
     *             key
     * @param: @param
     *             value
     * @returnType:@param key
     * @returnType:@param value void
     */
    public Object setAttribute(Object value) {
        // 生成SessionId
        String sessionId = TokenUtils.getToken();
        cacheManager.put(sessionId, value);
        return sessionId;

    }

    public Object getAttribute(String key) {
        return cacheManager.get(key);
    }
}
