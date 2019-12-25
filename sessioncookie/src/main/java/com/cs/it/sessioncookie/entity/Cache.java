package com.cs.it.sessioncookie.entity;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/25 16:43
 */

import lombok.Data;

/**
 * 缓存实体类
 */
@Data
public class Cache {
    private String key;//key
    private Object value;//值
    private Long timeout;//有效期
}
