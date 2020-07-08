package com.aaa.cehui.controller;


import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.User;
import com.aaa.cehui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/8 11:48
 * @Description
 **/
@RestController
public class UserController extends CommonController<User> {

    @Autowired
    private UserService userService;

    @Override
    public BaseService<User> getBaseService() {
        return userService;
    }

    @PostMapping("/add")
    public ResultData add(User user) {
        return userService.insertDta(user);
    }

    @PostMapping("/add")
    public ResultData selectAllRoles() {
        return userService.selectAllRoles();
    }

}
