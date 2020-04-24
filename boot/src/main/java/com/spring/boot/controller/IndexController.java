package com.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2020/4/22 15:29
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "余胜军");
        map.put("sex",1);//0 男 1 女 其他
        List<String> userList=new ArrayList<String>();
        userList.add("张三");
        userList.add("王五");
        userList.add("王麻子");
        map.addAttribute("userList", userList);
        return "index";
    }
}
