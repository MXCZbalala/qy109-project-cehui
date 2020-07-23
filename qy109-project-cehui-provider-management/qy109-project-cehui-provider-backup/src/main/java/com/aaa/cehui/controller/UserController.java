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
import tk.mybatis.mapper.util.Sqls;

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

    /**
     * @Author LTL
     * @Description 新增用户信息
     * @Param [user]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:26
     * @Throws
     */
    @RequestMapping("/addUser")
    public ResultData addUser(@RequestBody User user) {
        return userService.addUser(user) ? addSuccess() : addFiled();
    }

    /**
     * @Author LTL
     * @Description 通过ID删除一条用户信息
     * @Param [user]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:37
     * @Throws
     */
    @PostMapping("/deleteById")
    public ResultData deleteById(@RequestBody User user) {
        return userService.delete(user) > 0 ? deleteSuccess() : deleteFiled();
    }

    /**
     * @Author LTL
     * @Description 通过主键批量删除用户信息
     * @Param [ids]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:28
     * @Throws
     */
    @PostMapping("/deleteUserByIds")
    public ResultData deleteUserByIds(@RequestParam("ids[]") List<Integer> ids) {
        return userService.deleteByIds(ids) > 0 ? deleteSuccess() : deleteFiled();
    }

    /**
     * @Author LTL
     * @Description 通过id修改用户信息
     * @Param [user]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:31
     * @Throws
     */
    @PostMapping("/updateUserById")
    public ResultData updateUserById(@RequestBody User user) {
        return userService.updateUser(user) > 0 ? updateSuccess() : updateFiled();
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
    public ResultData selectAllUser(@RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize
    ) {
        return userService.selectAllUser(pageNo, pageSize) != null ? getSuccess(userService.selectAllUser(pageNo, pageSize)) : getFiled();
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

    ) {
        return userService.selectUserById(id) != null ? getSuccess(userService.selectUserById(id)) : getFiled();
    }


    /**
     * @Author LTL
     * @Description 多条件查询用户信息
     * @Param [map, pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:43
     * @Throws
     */
    @PostMapping("/selectUserByFiled")
    public ResultData selectUserByFiled(@RequestBody Map map,
                                        @RequestParam("pageNo") Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize
    ) {
        System.out.println(map.toString());
        System.out.println(pageNo);
        System.out.println(pageSize);
        return userService.selectUserByFiled(map, pageNo, pageSize).getSize() > 0 ? getSuccess(userService.selectUserByFiled(map, pageNo, pageSize)) : getFiled();
    }


}
