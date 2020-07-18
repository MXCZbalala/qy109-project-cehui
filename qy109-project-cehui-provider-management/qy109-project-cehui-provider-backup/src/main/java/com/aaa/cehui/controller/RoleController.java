package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Role;
import com.aaa.cehui.model.RoleMenu;
import com.aaa.cehui.service.RoleMenuService;
import com.aaa.cehui.service.RoleSerivce;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author ltl
 * @Date 2020/7/17  14:42
 * @Description
 *      系统管理--角色管理
 **/
@RestController
public class RoleController  extends CommonController<Role> {

    @Autowired
    private RoleSerivce roleSerivce;
    @Autowired
    RoleMenuService roleMenuService;
    public BaseService<Role> getBaseService() {
        return roleSerivce;
    }

    /**
    * @Author LTL
    * @Description 分页查询所有角色信息
    * @Param [pageNo, pageSize]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/17  14:46
    * @Throws
    */
    @PostMapping("/selectAllRole")
    public ResultData selectAllRole(@RequestParam("pageNo")Integer pageNo,
                                    @RequestParam("pageSize")Integer pageSize
    ){
        List<Role> roles = getBaseService().selectAll(pageNo, pageSize);
        if (null != roles){
            return getSuccess(roles);
        }else {
           return getFiled();
        }
    }

    /**
    * @Author LTL
    * @Description
     *      根据日期或角色名
     *      分页模糊查询角色信息
    * @Param [map, pageNo, pageSize]
    * @Return com.github.pagehelper.PageInfo
    * @DateTime 2020/7/17  16:48
    * @Throws
    */
    @PostMapping("/selectRoleByFiled")
    public PageInfo selectRoleByFiled(@RequestBody Map map,
                                        @RequestParam("pageNo")Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize
    ){
        return roleSerivce.selectRoleByFiled(map,pageNo,pageSize);
    }


    /**
    * @Author LTL
    * @Description 根据ID修改角色信息
    * @Param [role]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/17  16:56
    * @Throws
    */
    @PostMapping("/updateRoleById")
    public ResultData updateRoleById(@RequestBody Role role,
                                     @RequestParam("ids[]")List<Integer> ids){
        Integer integer = roleSerivce.updateRoleByPrimaryKey(role);
        roleMenuService.deleteMenuByRoleId(role.getRoleId());
        Integer add = roleMenuService.add(role.getRoleId(), ids);
        if (add > 0){
            return updateSuccess();
        }else {
            return updateFiled();
        }
    }

    /**
    * @Author LTL
    * @Description 新增角色信息
    * @Param [role]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/17  17:02
    * @Throws
    */
    @PostMapping("/addRole")
    public ResultData addRole(@RequestBody Role role,
                              @RequestParam("ids[]")List<Integer> ids
    ){
        Integer add = roleSerivce.add(role);
        roleMenuService.add(role.getRoleId(),ids);
        if (add > 0 ){
            return addSuccess();
        }else {
            return addFiled();
        }
    }


}
