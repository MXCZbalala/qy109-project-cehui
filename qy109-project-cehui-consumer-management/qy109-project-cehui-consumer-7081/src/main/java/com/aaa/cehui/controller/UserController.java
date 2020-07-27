package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.User;
import com.aaa.cehui.service.SystemApiService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author ltl
 * @Date 2020/7/27  11:01
 * @Description
 **/
@RestController
@Api(value = "用户信息", tags = "用户管理")
public class UserController extends BaseController {

    @Autowired
    private SystemApiService systemApiService;

    /**
     * @Author LTL
     * @Description 新增用户信息
     * @Param [user]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:26
     * @Throws
     */
    @RequestMapping("/addUser")
    @ApiOperation(value = "新增用户",
            notes = "通过添加用户属性来新增用户信息")
    public ResultData addUser(@RequestBody User user) {
        return systemApiService.addUser(user);
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
    @ApiOperation(value = "删除用户",
            notes = "通过ID删除一条用户信息")
    public ResultData deleteById(@RequestBody User user){
        return systemApiService.deleteById(user);
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
    @ApiOperation(value = "批量删除用户",
            notes = "通过ID集合删除用户信息")
    public ResultData deleteUserByIds(@RequestParam("ids[]") List<Integer> ids){
        return systemApiService.deleteUserByIds(ids);
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
    @ApiOperation(value = "修改用户信息",
            notes = "通过ID修改用户信息")
    public ResultData updateUserById(@RequestBody User user){
        return updateUserById(user);
    }

    /**
    * @Author LTL
    * @Description 分页查询所有用户信息
    * @Param [pageNo, pageSize]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/27  11:06
    * @Throws
    */
    @GetMapping("/selectAllUser")
    @ApiOperation(value = "查询用户信息",
            notes = "分页查询所有用户信息")
    public ResultData selectAllUser(@RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize")Integer pageSize){
        return systemApiService.selectAllUser(pageNo, pageSize);
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
    @ApiOperation(value = "通过ID查询用户信息",
            notes = "通过用户ID查询用户信息")
    public ResultData selectUserById(@RequestParam("id") Integer id){
        return selectUserById(id);
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
    @ApiOperation(value = "多条件查询用户信息",
            notes = "多条件查询用户信息")
    public ResultData selectUserByFiled(@RequestBody Map map,
                                        @RequestParam("pageNo") Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize
    ){
        return systemApiService.selectUserByFiled(map,pageNo,pageSize);
    }

}
