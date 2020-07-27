package com.aaa.cehui.service;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.*;
import com.aaa.cehui.vo.TokenVo;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author ltl
 * @Date 2020/7/27  8:39
 * @Description
 **/
@FeignClient("interface-provider-backup")
public interface SystemApiService {

    /**
     * @Author LTL
     * @Description 登录接口
     * @Param [user]
     * @Return TokenVo
     * @DateTime 2020/7/27  8:40
     * @Throws
     */
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody User user);

    /**
     * @Author LTL
     * @Description 新增登录日志
     * @Param [map]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/27  8:43
     * @Throws
     */
    @PostMapping("/log/addLoginLog")
    ResultData addLoginLog(@RequestBody Map map);


    /**
     * @Author LTL
     * @Description 新增部门按钮
     * @Param [dept]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/27  8:44
     * @Throws
     */
    @PostMapping("/addDept")
    ResultData addDept(@RequestBody Dept dept);


    /**
     * @Author LTL
     * @Description 通过id删除部门
     * @Param [dept]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/27  8:44
     * @Throws
     */
    @PostMapping("/deleteDeptById")
    ResultData deleteDeptById(@RequestBody Dept dept);

    /**
     * @Author LTL
     * @Description 修改部门信息表
     * @Param [dept]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/27  8:45
     * @Throws
     */
    @PostMapping("/updateDept")
    ResultData updateDept(@RequestBody Dept dept);

    /**
     * @Author LTL
     * @Description 分页查询所有部门信息
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/27  8:45
     * @Throws
     */
    @GetMapping("/selectAllDept")
    ResultData selectAllDept(@RequestParam("pageNo") Integer pageNo,
                             @RequestParam("pageSize") Integer pageSize);


    /**
     * @Author LTL
     * @Description 分页条件查询部门信息
     * @Param [map, pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/27  8:46
     * @Throws
     */
    @PostMapping("/selectDeptInfoByField")
    ResultData selectDeptInfoByField(@RequestBody Map map,
                                     @RequestParam("pageNo") Integer pageNo,
                                     @RequestParam("pageSize") Integer pageSize);

    /**
     * @Author LTL
     * @Description 通过主键批量删除部门信息
     * @Param [ids]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/27  8:47
     * @Throws
     */
    @PostMapping("/batchDeleteByPrimaryKey")
    ResultData batchDeleteByPrimaryKey(@RequestParam("ids[]") List<Integer> ids);


    /**
     * @Author LTL
     * @Description 查询所有字典信息
     * @Param []
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/27  8:48
     * @Throws
     */
    @PostMapping("/queryAllDict")
    ResultData selectDict();

    /**
     * @Author LTL
     * @Description 新增字典信息
     * @Param [dict]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/27  8:49
     * @Throws
     */
    @PostMapping("/addDict")
    ResultData addDict(Dict dict);


    /**
     * @Author LTL
     * @Description 通过主键批量删除字典信息
     * @Param [dictIds]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/27  8:49
     * @Throws
     */
    @RequestMapping("/deleteDict")
    ResultData deleteDict(@RequestParam("dictIds") List<Integer> dictIds);


    /**
     * @Author LTL
     * @Description 查询需要修改的信息
     * @Param [dictId]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/27  8:50
     * @Throws
     */
    @PostMapping("/selectUpdateDict")
    ResultData selectUpdateDict(@RequestParam("dictId") Long dictId);


    /**
     * @Author LTL
     * @Description 修改查询出来的信息
     * @Param [dict]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/27  8:50
     * @Throws
     */
    @RequestMapping("/updateDict")
    ResultData updateDict(Dict dict);

    /**
     * @Description: 字典的分页查询信息
     * @Param: [dict, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/16
     */
    @PostMapping("/selectDictByPage")
    ResultData selectDictByPage(@RequestBody Dict dict,
                                @RequestParam("pageNo") Integer pageNo,
                                @RequestParam("pageSize") Integer pageSize);

    /**
     * @Author LTL
     * @Description 修改菜单信息
     * @Param [menu]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/17  22:48
     * @Throws
     */
    @PostMapping("/updateMenu")
    ResultData updateMenu(@RequestBody Menu menu);

    /**
     * @Author LTL
     * @Description 通过用户ID查询用户拥有的权限
     * @Param [user]
     * @Return java.util.List<com.aaa.cehui.model.Menu>
     * @DateTime 2020/7/20  8:34
     * @Throws
     */
    @PostMapping("/getMenuByUserId")
    ResultData getMenuByUserId(@RequestBody User user);

    /**
     * @Author LTL
     * @Description 通过角色ID查询角色菜单信息
     * @Param [roleId]
     * @Return java.lang.Object
     * @DateTime 2020/7/18  8:41
     * @Throws
     */
    @PostMapping("/getMenuByRoleId")
    ResultData getMenuByRoleId(@RequestParam("roleId") Long roleId);

    /**
     * @Author LTL
     * @Description 通过角色ID 修改菜单信息
     * @Param [roleId]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  22:13
     * @Throws
     */
    @PostMapping("/updateMenuByRoleId")
    ResultData updateMenuByRoleId(@RequestParam("roleId") Long roleId);

    /**
     * @Author LTL
     * @Description 查询所有的菜单信息
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/18  9:56
     * @Throws
     */
    @PostMapping("/selectAllMenu")
    ResultData selectAllMenu();

    /**
     * @Author LTL
     * @Description 通过菜单ID 修改菜单信息
     * @Param [menu]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  22:01
     * @Throws
     */
    @PostMapping("/updateMenuByMenuId")
    ResultData updateMenuByMenuId(@RequestBody Menu menu);

    /**
     * @Author LTL
     * @Description 分页查询所有一级菜单
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/18  15:36
     * @Throws
     */
    @PostMapping("/selectAllParentMenu")
    PageInfo<Menu> selectAllParentMenu(@RequestParam("pageNo") Integer pageNo,
                                       @RequestParam("pageSize") Integer pageSize);

    /**
     * @Author LTL
     * @Description 通过父级菜单查询子菜单
     * @Param [parentId, where]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/18  15:54
     * @Throws
     */
    @PostMapping("/selectChildMenuByParentId")
    ResultData selectChildMenu(@RequestParam("parentId") Integer parentId);


    /**
     * @Author LTL
     * @Description 通过条件查询所有菜单信息
     * @Param [map, where]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  22:11
     * @Throws
     */
    @PostMapping("/selectMenuByFiled")
    ResultData selectMenuByFiled(@RequestBody Map map);

    /**
     * @Author LTL
     * @Description 分页查询所有角色信息
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/17  14:46
     * @Throws
     */
    @PostMapping("/selectAllRole")
    ResultData selectAllRole(@RequestParam("pageNo") Integer pageNo,
                             @RequestParam("pageSize") Integer pageSize);


    /**
     * @Author LTL
     * @Description 根据日期或角色名
     * 分页模糊查询角色信息
     * @Param [map, pageNo, pageSize]
     * @Return com.github.pagehelper.PageInfo
     * @DateTime 2020/7/17  16:48
     * @Throws
     */
    @PostMapping("/selectRoleByFiled")
    ResultData selectRoleByFiled(@RequestBody Map map,
                                 @RequestParam("pageNo") Integer pageNo,
                                 @RequestParam("pageSize") Integer pageSize);

    /**
     * @Author LTL
     * @Description 根据ID修改角色信息
     * @Param [role]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/17  16:56
     * @Throws
     */
    @PostMapping("/updateRoleById")
    ResultData updateRoleById(@RequestBody Role role,
                              @RequestParam("ids[]") List<Integer> ids);

    /**
     * @Author LTL
     * @Description 新增角色信息
     * @Param [role]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/17  17:02
     * @Throws
     */
    @PostMapping("/addRole")
    ResultData addRole(@RequestBody Role role,
                       @RequestParam("ids[]") List<Integer> ids);

    /**
     * @Author LTL
     * @Description 批量删除角色信息
     * @Param [ids]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:23
     * @Throws
     */
    @PostMapping("/deleteRoleByIds")
    ResultData deleteRoleByIds(@RequestParam("ids[]") List<Integer> ids);


    /**
     * @Author LTL
     * @Description 新增用户信息
     * @Param [user]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:26
     * @Throws
     */
    @RequestMapping("/addUser")
    ResultData addUser(@RequestBody User user);

    /**
     * @Author LTL
     * @Description 通过ID删除一条用户信息
     * @Param [user]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:37
     * @Throws
     */
    @PostMapping("/deleteById")
    ResultData deleteById(@RequestBody User user);

    /**
     * @Author LTL
     * @Description 通过主键批量删除用户信息
     * @Param [ids]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:28
     * @Throws
     */
    @PostMapping("/deleteUserByIds")
    ResultData deleteUserByIds(@RequestParam("ids[]") List<Integer> ids);

    /**
     * @Author LTL
     * @Description 通过id修改用户信息
     * @Param [user]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:31
     * @Throws
     */
    @PostMapping("/updateUserById")
    ResultData updateUserById(@RequestBody User user);

    /**
     * @Author LTL
     * @Description 分页查询所有用户信息
     * @Param [pageNo, pageSize]
     * @Return com.github.pagehelper.PageInfo
     * @DateTime 2020/7/16  8:57
     * @Throws
     */
    @PostMapping("/selectAllUser")
    ResultData selectAllUser(@RequestParam("pageNo") Integer pageNo,
                             @RequestParam("pageSize") Integer pageSize);

    /**
     * @Author LTL
     * @Description 通过用户ID查询用户信息
     * @Param [user]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  15:01
     * @Throws
     */
    @PostMapping("/selectUserById")
    ResultData selectUserById(@RequestParam("id") Integer id);

    /**
     * @Author LTL
     * @Description 多条件查询用户信息
     * @Param [map, pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:43
     * @Throws
     */
    @PostMapping("/selectUserByFiled")
    ResultData selectUserByFiled(@RequestBody Map map,
                                 @RequestParam("pageNo") Integer pageNo,
                                 @RequestParam("pageSize") Integer pageSize);



}
