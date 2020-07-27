package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Menu;
import com.aaa.cehui.model.User;
import com.aaa.cehui.service.SystemApiService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author ltl
 * @Date 2020/7/27  11:17
 * @Description
 **/
@RestController
@Api(value = "菜单管理", tags = "权限信息")
public class MenuManagement {
    @Autowired
    private SystemApiService systemApiService;

    /**
     * @Author LTL
     * @Description 通过用户ID查询用户拥有的权限
     * @Param [user]
     * @Return java.util.List<com.aaa.cehui.model.Menu>
     * @DateTime 2020/7/20  8:34
     * @Throws
     */
    @PostMapping("/getMenuByUserId")
    public ResultData getMenuByUserId(@RequestBody User user){
        return systemApiService.getMenuByUserId(user);
    }

    /**
     * @Author LTL
     * @Description 通过角色ID查询角色菜单信息
     * @Param [roleId]
     * @Return java.lang.Object
     * @DateTime 2020/7/18  8:41
     * @Throws
     */
    @PostMapping("/getMenuByRoleId")
    public ResultData getMenuByRoleId(@RequestParam Long roleId){
        return systemApiService.getMenuByRoleId(roleId);
    }

    /**
     * @Author LTL
     * @Description 通过角色ID 修改菜单信息
     * @Param [roleId]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  22:13
     * @Throws
     */
    @PostMapping("/updateMenuByRoleId")
    public ResultData updateMenuByRoleId(@RequestParam("roleId") Long roleId){
        return systemApiService.updateMenuByRoleId(roleId);
    }
    /**
     * @Author LTL
     * @Description 查询所有的菜单信息
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/18  9:56
     * @Throws
     */
    @PostMapping("/selectAllMenu")
    public ResultData selectAllMenu(){
        return systemApiService.selectAllMenu();
    }


    /**
     * @Author LTL
     * @Description 通过菜单ID 修改菜单信息
     * @Param [menu]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  22:01
     * @Throws
     */
    @PostMapping("/updateMenuByMenuId")
    public ResultData updateMenuByMenuId(@RequestBody Menu menu){
        return systemApiService.updateMenuByMenuId(menu);
    }

    /**
     * @Author LTL
     * @Description 分页查询所有一级菜单
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/18  15:36
     * @Throws
     */
    @PostMapping("/selectAllParentMenu")
    public PageInfo<Menu> selectAllParentMenu(@RequestParam("pageNo") Integer pageNo,
                                              @RequestParam("pageSize") Integer pageSize){
        return systemApiService.selectAllParentMenu(pageNo, pageSize);
    }

    /**
     * @Author LTL
     * @Description 通过父级菜单查询子菜单
     * @Param [parentId, where]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/18  15:54
     * @Throws
     */
    @PostMapping("/selectChildMenuByParentId")
    public ResultData selectChildMenu(@RequestParam("parentId") Integer parentId){
        return systemApiService.selectChildMenu(parentId);
    }

    /**
     * @Author LTL
     * @Description 通过条件查询所有菜单信息
     * @Param [map, where]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  22:11
     * @Throws
     */
    @PostMapping("/selectMenuByFiled")
    public ResultData selectMenuByFiled(@RequestBody Map map){
        return systemApiService.selectMenuByFiled(map);
    }


}
