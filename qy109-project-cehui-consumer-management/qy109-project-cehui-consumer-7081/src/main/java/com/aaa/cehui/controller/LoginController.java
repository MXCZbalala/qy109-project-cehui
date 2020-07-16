package com.aaa.cehui.controller;

import com.aaa.cehui.annotation.LoginAnnotation;
import com.aaa.cehui.base.BaseController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.User;
import com.aaa.cehui.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/15 9:14
 * @Description
 **/
@RestController
public class LoginController extends BaseController {

    @Autowired
    private IProjectService projectService;

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @param [user]
     * @date 2020/7/15
     * @return com.aaa.lee.base.ResultData
     * @throws
    **/
    @PostMapping("/doLogin")
    @LoginAnnotation(opeationType = "登录操作", opeationName = "管理员登录")
    public ResultData doLogin(User user) {
        return projectService.doLogin(user);
    }

}
