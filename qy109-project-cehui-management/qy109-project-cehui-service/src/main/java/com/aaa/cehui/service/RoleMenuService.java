package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.RoleMenuMapper;
import com.aaa.cehui.model.Menu;
import com.aaa.cehui.model.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/17  18:43
 * @Description
 **/
@Service
public class RoleMenuService extends BaseService<RoleMenu> {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
    * @Author LTL
    * @Description 通过ID 删除权限信息
    * @Param [roleId]
    * @Return java.lang.Integer
    * @DateTime 2020/7/18  9:39
    * @Throws
    */
    public Integer deleteMenuByRoleId(Long roleId){
        return roleMenuMapper.deleteMenuByRoleId(roleId);
    }

    /**
    * @Author LTL
    * @Description 通过ID批量增加角色权限信息
    * @Param [roleId, menuId]
     *      返回一共有几条进行了修改
    * @Return java.lang.Integer
    * @DateTime 2020/7/18  9:41
    * @Throws
    */
    public Integer add(Long roleId, List<Integer> menuId){

        Integer num = 0;
        for (int i = 0; i < menuId.size(); i++) {
            Integer integer = roleMenuMapper.insertMenuByRoleId(roleId, menuId.get(i));
            if (integer>0){
                num++;
            }

        }
        return num;
    }

}
