package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.model.LoginLogs;
import com.aaa.cehui.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/15 12:05
 * @Description
 **/
@RestController
public class LoginLogController extends CommonController<LoginLogs> {

    @Autowired
    private LoginLogService loginLogService;

    @Override
    public BaseService<LoginLogs> getBaseService() {
        return loginLogService;
    }

    /**
     * @author Seven Lee
     * @description
     *      保存日志
     * @param [loginLog]
     * @date 2020/7/15
     * @return java.lang.Integer
     * @throws
    **/
    @PostMapping("/addLoginLog")
    public Integer addLoginLog(@RequestBody LoginLogs loginLog) {
        return getBaseService().add(loginLog);
    }


}
