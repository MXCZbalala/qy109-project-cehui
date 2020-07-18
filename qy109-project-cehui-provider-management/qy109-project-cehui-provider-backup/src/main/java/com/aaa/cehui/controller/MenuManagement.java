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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


    @PostMapping("/getMenuByUserId")
    public List<Menu> getMenuByUserId(@RequestBody User user){
        return menuService.selectMenuByUserId(user,user_roleService,role_menuService);
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
    public List<Menu> getMenuByRoleId(@RequestParam Long roleId,RoleMenuService roleMenuService) {



        return  null;
    }


    @PostMapping("/updateMenuByRoleId")
    public Integer updateMenuByRoleId(@RequestParam("ids[]") List<Integer> ids,
                                      @RequestParam("roleId") Integer roleId) {
        Integer integer = role_menuService.deleteMenuByRoleId(roleId);
        if (integer > 0) {
            return role_menuService.add(roleId, ids);
        } else {
            return 0;
        }
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
    public ResultData selectAllMenu(@RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize
    ) {
        return getSuccess(getBaseService().selectAll(pageNo, pageSize));
    }

    @PostMapping("/updateMenuByMenuId")
    public ResultData updateMenuByMenuId(@RequestBody Menu menu) {
      return   updateSuccess(getBaseService().update(menu));
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
                                          @RequestParam("pageSize") Integer pageSize,
                                          Sqls where
    ){
        return getBaseService().selectListByPageAndFiled(pageNo,pageSize,where.andEqualTo("parentId",1),null);
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
    public ResultData selectChildMenu(@RequestParam("parentId") Integer parentId,
                                          Sqls where){
        return getSuccess(getBaseService().selectListByFiled(where.andEqualTo("parentId",parentId),null));
    }


}
