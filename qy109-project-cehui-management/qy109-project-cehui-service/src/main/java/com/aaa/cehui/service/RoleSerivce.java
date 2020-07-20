package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.RoleMapper;
import com.aaa.cehui.model.Role;
import com.aaa.cehui.model.RoleMenu;
import com.aaa.cehui.utils.DateUtils;
import com.github.pagehelper.PageInfo;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.aaa.cehui.staticproperties.TimeForatProperties.TIME_FORMAT;

/**
 * @Author ltl
 * @Date 2020/7/17  14:40
 * @Description 系统管理--角色管理
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
    public PageInfo selectRoleByFiled(Map map, Integer pageNo, Integer pageSize, Sqls where) {
        Object roleName = map.get("roleName");
        Object beginTime = map.get("beginTime");
        Object endTime = map.get("endTime");
        if (null != roleName & !"".equals(roleName) && null != beginTime && !"".equals(beginTime) & null != endTime & !"".equals(endTime)) {
            return super.selectListByPageAndFiled(pageNo, pageSize, where.andLike("roleName", roleName.toString()).andBetween("createTime", beginTime, endTime), null);
        } else if (null != roleName && !"".equals(roleName)) {
            return super.selectListByPageAndFiled(pageNo, pageSize, where.andLike("roleName", roleName.toString()), null);
        } else if (null != beginTime & !"".equals(beginTime) && null != endTime & !"".equals(endTime)) {
            return super.selectListByPageAndFiled(pageNo, pageSize, where.andBetween("createTime", beginTime, endTime), null);
        }
        return null;
    }


    /**
     * @Author LTL
     * @Description 根据ID  修改角色信息
     * @Param [role]
     * @Return java.lang.Integer
     * @DateTime 2020/7/17  16:54
     * @Throws
     */
    public Integer updateRoleByPrimaryKey(Role role, List<Integer> ids, RoleMenuService roleMenuService) {
        role.setModifyTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
        Integer updateRoleByPrimaryKey = roleMapper.updateRoleByPrimaryKey(role);
        if (updateRoleByPrimaryKey > 0) {
            Integer deleteByIds = roleMenuService.delete(new RoleMenu().setRoleId(role.getRoleId()));
            if (deleteByIds > 0) {
                // 删除当前权限 往中间表中添加权限类型
                return roleMenuService.add(role.getRoleId(), ids);
            } else {
                //说明删除权限删除失败
                return 0;
            }
        } else {
            //说明修改角色信息修改失败
            return 0;
        }
    }


    /**
     * @Author LTL
     * @Description 批量删除角色信息
     * @Param [roleIds]
     * @Return java.lang.Boolean
     * @DateTime 2020/7/17  17:05
     * @Throws
     */
    public Boolean deleteRoleByRoleId(List<Integer> roleIds) {
        //判断前段是否传值成功
        if (!"".equals(roleIds) && null != roleIds) {
            try {
                //调用父类重载的批量删除方法
                Integer integer = super.deleteByIds(roleIds);
                if (integer > 0) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * @Author LTL
     * @Description 新增角色信息，增加权限信息
     * @Param [role, ids, roleMenuService]
     * @Return java.lang.Boolean
     * @DateTime 2020/7/20  19:06
     * @Throws
     */
    public Boolean addRole(Role role, List<Integer> ids, RoleMenuService roleMenuService) {
        role.setCreateTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
        int insert = roleMapper.insert(role);
        if (insert > 0) {
            //新增成功
            if (ids.size() > 0) {
                //说明需要增加角色权限信息
                Integer add = roleMenuService.add(role.getRoleId(), ids);
                if (add > 0) {
                    // 说明新增角色信息成功，权限赋予成功
                    return true;
                } else {
                    // 说明新增角色成功，但并没有赋予权限
                    return false;
                }
            }
            //说明无需赋予权限
            return true;
        }
        //说明新增失败
        return false;
    }

}
