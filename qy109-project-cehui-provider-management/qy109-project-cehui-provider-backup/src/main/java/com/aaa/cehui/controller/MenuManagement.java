package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Menu;
import com.aaa.cehui.model.RoleMenu;
import com.aaa.cehui.model.User;
import com.aaa.cehui.model.UserRole;
import com.aaa.cehui.service.*;
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
public class MenuManagement   {

    @Autowired
    private UserRoleService user_roleService;

    @Autowired
    private RoleMenuService role_menuService;

    @Autowired
    private MenuService menuService;



    /**
     * @Author LTL
     * @Description 通过登录的ID 查询所拥有的菜单列表
     * @Param
     * @Return
     * @DateTime 2020/7/17  18:16
     * @Throws
     */
    @PostMapping("/getMenu")
    public Map<Integer, String> getMenu(@RequestBody User user) {
        System.out.println("UserId" + user.getId());
        Map<Integer, String> map = new HashMap<Integer, String>();
        List<Integer> menuId = new ArrayList<Integer>();
        //拿到了单个的角色信息
        UserRole roleId = user_roleService.selectOne(new UserRole().setRoleId(user.getId()));
        System.out.println("单个的UserId" + roleId);
        //通过角色ID 拿到菜单数组,
        List<RoleMenu> role_menus = role_menuService.selectList(new RoleMenu().setRoleId(roleId.getRoleId()));
        System.out.println("通过角色ID 拿到的菜单数组" + role_menus);
        for (int i = 0; i < role_menus.size(); i++) {
            menuId.add(role_menus.get(i).getMenuId());
        }
        System.out.println("转化过的menuId" + menuId.toString());

        if (menuId.size() > 0) {
            //拿到所有的MenuId 开始查询所有的MenuName
            System.out.println(menuId.get(21));
            ;
            for (int m = 0; m < menuId.size(); m++) {
                map.put(menuId.get(m), menuService.selectMenuNameById(menuId.get(m)));
            }
            return map;
        }
        return null;
    }




}
