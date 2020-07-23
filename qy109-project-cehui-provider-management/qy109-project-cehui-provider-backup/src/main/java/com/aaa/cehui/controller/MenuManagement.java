package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Menu;
import com.aaa.cehui.model.RoleMenu;
import com.aaa.cehui.model.User;
import com.aaa.cehui.model.UserRole;
import com.aaa.cehui.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.Map;


/**
 * @Author ltl
 * @Date 2020/7/17  18:01
 * @Description
 **/
@RestController
public class MenuManagement extends CommonController<Menu> {

    @Autowired
    private UserRoleService user_roleService;

    @Autowired
    private RoleMenuService role_menuService;

    @Autowired
    private MenuService menuService;

    public BaseService<Menu> getBaseService() {
        return menuService;
    }


    /**
     * @Author LTL
     * @Description 通过用户ID查询用户拥有的权限
     * @Param [user]
     * @Return java.util.List<com.aaa.cehui.model.Menu>
     * @DateTime 2020/7/20  8:34
     * @Throws
     */
    @PostMapping("/getMenuByUserId")
    public ResultData getMenuByUserId(@RequestBody User user) {
        return menuService.selectMenuByUserId(user, user_roleService, role_menuService).size() > 0 ? getSuccess(menuService.selectMenuByUserId(user, user_roleService, role_menuService)) : getFiled();
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
    public ResultData getMenuByRoleId(@RequestParam Long roleId, RoleMenuService roleMenuService) {
        return menuService.getMenuByRoleId(roleId, roleMenuService).size() > 0 ? getSuccess(menuService.getMenuByRoleId(roleId, roleMenuService)) : getFiled("为查询到数据");
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
    public ResultData updateMenuByRoleId(@RequestParam("roleId") Long roleId) {
        return role_menuService.deleteMenuByRoleId(roleId) > 0 ? updateSuccess(role_menuService.deleteMenuByRoleId(roleId)) : getFiled();
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
    public ResultData selectAllMenu() {
        return menuService.selectAllMenus().size() > 0 ? getSuccess(menuService.selectAllMenus()) : getFiled("网络异常，查询失败");
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
    public ResultData updateMenuByMenuId(@RequestBody Menu menu) {
        return menuService.updateMenuByMenuId(menu) > 0 ? updateSuccess(menuService.updateMenuByMenuId(menu)) : updateFiled();
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
                                              @RequestParam("pageSize") Integer pageSize
    ) {
        return getBaseService().selectListByPageAndFiled(pageNo, pageSize, Sqls.custom().andEqualTo("parentId", 1), null);
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
    public ResultData selectChildMenu(@RequestParam("parentId") Integer parentId) {
        return getSuccess(getBaseService().selectListByFiled(Sqls.custom().andEqualTo("parentId", parentId), null));
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
    public ResultData selectMenuByFiled(@RequestBody Map map) {
        return menuService.selectMenusByFiled(map).size() > 0 ? getSuccess(menuService.selectMenusByFiled(map)) : getFiled("未查到");
    }

}
