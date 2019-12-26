package com.cs.it.sessioncookie.utils;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @Description 请求参数转化器
 * @Author cuishuai
 * @Date 2019/12/26 9:41
 */
public class XssAndSplHttpServletWrapper extends HttpServletRequestWrapper{
    private HttpServletRequest request;

    public XssAndSplHttpServletWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    /**
     * 将requert中的value值 重写 将一些 脚本参数 非法参数 转换成html元素执行
     * @param name
     * @return
     */
    @Override
    public String getParameter(String name) {
        String value = this.request.getParameter("name");
        if(!StringUtils.isEmpty(value)){
            System.out.println("转换前:" + value);
            //将value 转换成html
            value = StringEscapeUtils.escapeHtml4(value);
            System.out.println("转换后:" + value);
        }
        return value;
    }
}
