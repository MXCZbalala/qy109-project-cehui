package com.aaa.cehui.mapper;

import com.aaa.cehui.model.RoleMenu;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author ltl
 * @Date 2020/7/17  19:38
 * @Description
 **/
public interface RoleMenuMapper extends Mapper<RoleMenu> {

    Integer deleteMenuByRoleId(Integer roleId);

    Integer insertMenuByRoleId(Integer roleId,Integer menuId);
}
