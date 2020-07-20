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


    @Override
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
        return userService.selectAllUser(pageNo, pageSize);
    }

    /**
    * @Author LTL
    * @Description 通过用户ID查询用户信息
    * @Param [user]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  15:01
    * @Throws
    */
    @PostMapping("/selectUserById")
    public ResultData selectUserById(@RequestParam("id") Integer id

    ){
        return getSuccess(userService.selectUserById(id));
    }

    /**
    * @Author LTL
    * @Description 通过部门编号分页查询用户
    * @Param [deptno]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  14:59
    * @Throws
    */
    @PostMapping("/selectUserByDept")
    public ResultData selectUserByDept(@RequestParam("deptno") Integer deptno,
                                       @RequestParam("pageNo") Integer pageNo,
                                       @RequestParam("pageSize") Integer pageSize
    ){
        if (null != getSuccess(userService.selectUserByDeptNo(deptno,pageNo,pageSize))){
            return getSuccess(userService.selectUserByDeptNo(deptno,pageNo,pageSize));
        }
        return getFiled("未查询到数据");
    }

    @PostMapping("/deleteById")
    public ResultData deleteById(User user){
         if (userService.delete(user)>0){
             return deleteSuccess();
         }else {
             return deleteFiled();
         }
    }

    @PostMapping("/updateById")
    public ResultData updateById(User user){
         if(userService.updateUser(user)>0){
             return updateSuccess();
         }
         else {
             return updateFiled();
         }
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
