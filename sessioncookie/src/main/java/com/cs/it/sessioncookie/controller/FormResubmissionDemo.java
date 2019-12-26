package com.cs.it.sessioncookie.controller;

import com.cs.it.sessioncookie.utils.TokenUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description 防止 表单重复提交
 * @Author cuishuai
 * @Date 2019/12/25 17:23
 */

/**
 * 表单重复提交 常用两个 常用办法
 * 1.通过前端解决   遮罩
 * 2.通过后端解决  token + session
 */
@Controller
@RequestMapping("form")
public class FormResubmissionDemo {


    /**
     *  转发到页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("formReSubDispatcher")
    public void formReSub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //生成token
        String tokenValue = TokenUtils.getToken();
        HttpSession session = request.getSession();
        session.setAttribute("sessionToken",tokenValue);
        request.getRequestDispatcher("form.html").forward(request,response);
        //jsp页面 加哥 隐藏域  存token
    }


    /**
     * 请求
     * @param request
     * @param response
     */
    @RequestMapping("settData")
    public void request(HttpServletRequest request, HttpServletResponse response){
        if(!isSubmit(request)){
            System.out.println("你已经提交了数据===或者 token错误");
            return;
        }
        String userName = request.getParameter("userName");
        System.out.println("用户名:" + userName);
        request.getSession().removeAttribute("sessionToken");
    }


    /**
     * token验证
     * @param request
     * @return
     */
    public Boolean isSubmit(HttpServletRequest request){
        String paramToken = request.getParameter("paramToken");
        String sessionToken = (String) request.getSession().getAttribute("sessionToken");
        if(sessionToken == null){
            return false;
        }
        //判断是否伪造token
        if(!paramToken.equals(sessionToken)){
            return false;
        }
        return true;
    }
}
