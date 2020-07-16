package com.aaa.cehui.service;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.LoginLogs;
import com.aaa.cehui.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/15 9:30
 * @Description
 **/
@FeignClient(value = "system-interface")
public interface IProjectService {

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
    ResultData doLogin(@RequestBody User user);

    /**
     * @author Seven Lee
     * @description
     *      新增日志
     * @param [loginLog]
     * @date 2020/7/15
     * @return java.lang.Integer
     * @throws
    **/
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLogs loginLog);


}
