package com.aaa.cehui.controller;


import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.User;
import com.aaa.cehui.service.UserService;
import com.github.pagehelper.PageInfo;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
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


    public BaseService<User> getBaseService() {
        return userService;
    }

    @RequestMapping("/addUser")
    public ResultData addUser(@RequestBody User user){
        if (userService.addUser(user)){
            return addSuccess();
        }
        return addFiled();
    }
    /**
    * @Author LTL
    * @Description 分页查询所有用户信息
    * @Param [pageNo, pageSize]
    * @Return com.github.pagehelper.PageInfo
    * @DateTime 2020/7/16  8:57
    * @Throws
    */
    @PostMapping("/selectAllUser")
    public PageInfo selectAllUser(@RequestParam("pageNo") Integer pageNo,
                                  @RequestParam("pageSize") Integer pageSize
    ){
        return userService.selectListByPage(null, pageNo, pageSize);
    }

    @PostMapping("/selectUserById")
    public ResultData selectUserById(@RequestBody User user){
        return getSuccess(userService.selectList(user));
    }

    @PostMapping("/deleteById")
    public Integer deleteById(@RequestBody User user){
        return userService.delete(user);
    }

    @PostMapping("/updateById")
    public Integer updateById(@RequestBody User user){
        return userService.updateUser(user);
    }
    /**
    * @Author LTL
    * @Description 通过ID 批量删除
    * @Param
    * @Return
    * @DateTime 2020/7/16  9:55
    * @Throws
    */
    @Override
    @PostMapping("/updateByIds")
    public ResultData batchDelete(@RequestParam("ids[]") Integer[] ids){
        return super.batchDelete(ids);
    }

}
