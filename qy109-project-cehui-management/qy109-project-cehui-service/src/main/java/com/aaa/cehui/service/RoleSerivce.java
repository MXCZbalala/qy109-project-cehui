package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.RoleMapper;
import com.aaa.cehui.model.Role;
import com.aaa.cehui.model.User;
import com.aaa.cehui.utils.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * @Author ltl
 * @Date 2020/7/17  14:40
 * @Description
 *      系统管理--角色管理
 **/
@Service
public class RoleSerivce extends BaseService<Role> {

    @Autowired
    private RoleMapper roleMapper;


    /**
    * @Author LTL
    * @Description 分页实现条件插叙
    * @Param [map, pageNo, pageSize]
    * @Return com.github.pagehelper.PageInfo
    * @DateTime 2020/7/17  16:46
    * @Throws
    */
    public PageInfo selectRoleByFiled(Map map , Integer pageNo , Integer pageSize){

        PageHelper.startPage(pageNo,pageSize);
        List<Role> roles = roleMapper.selectRoleByField(map);
        if (roles.size()>0){
            PageInfo<Role> pageInfo = new PageInfo<>(roles);
            return pageInfo;
        }else{
            return null;
        }

    }



    /**
    * @Author LTL
    * @Description 根据ID  修改角色信息
    * @Param [role]
    * @Return java.lang.Integer
    * @DateTime 2020/7/17  16:54
    * @Throws
    */
    public Integer updateRoleByPrimaryKey(Role role){
        //判断前段是否传值成功
        if (!"".equals(role) && null !=role){
            //将当前时间传入修改时间
            role.setModifyTime(DateUtils.getCurrentDate());
            //调用修改方法
            try {
                int i = roleMapper.updateRoleByPrimaryKey(role);
                //判断是否修改成功
                if (i>0 ){
                    //返回受影响的行数
                    return i;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
    * @Author LTL
    * @Description 新增角色和对应权限
    * @Param [role]
    * @Return java.lang.Long
    * @DateTime 2020/7/17  16:57
    * @Throws
    */
    public Long insertRole(Role role){
        //判断前段是否传值成功
        if (!"".equals(role) && null !=role){
            //将角色名称传入
            role.setRoleName(role.getRoleName())
                    //将角色描述传入
                    .setRemark(role.getRemark())
                    //将创建时间传入
                    .setCreateTime(DateUtils.getCurrentDate());
            //执行新增
            Integer integer = roleMapper.insertRoleResultId(role);
            //获取返回的生成的id
            @NotNull Long roleId = role.getRoleId();
            if (null !=integer){
                return roleId;
            }
        }
        return null;
    }

    /**
    * @Author LTL
    * @Description 批量删除角色信息
    * @Param [roleIds]
    * @Return java.lang.Boolean
    * @DateTime 2020/7/17  17:05
    * @Throws
    */
    public Boolean deleteRoleByRoleId(List<Integer> roleIds){
        //判断前段是否传值成功
        if (!"".equals(roleIds) && null !=roleIds){
            try {
                //调用父类重载的批量删除方法
                Integer integer = super.deleteByIds(roleIds);
                if (integer>0){
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
