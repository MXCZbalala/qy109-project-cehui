package com.aaa.cehui.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author ltl
 * @Date 2020/7/22  20:17
 * @Description
 **/
@Controller
public class TurnPageController {

    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }
}
