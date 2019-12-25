package com.cs.it.sessioncookie.utils;

import java.util.UUID;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/25 17:15
 */
public class TokenUtils {
     public static String getToken() {
        return UUID.randomUUID().toString();
    }
}
