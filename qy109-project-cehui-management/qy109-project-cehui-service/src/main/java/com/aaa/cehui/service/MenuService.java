package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.MenuMapper;
import com.aaa.cehui.model.Menu;
import com.aaa.cehui.model.RoleMenu;
import com.aaa.cehui.model.User;
import com.aaa.cehui.model.UserRole;
import com.aaa.cehui.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.aaa.cehui.staticproperties.TimeForatProperties.TIME_FORMAT;
import static com.aaa.cehui.utils.DateUtils.DATE_TYPE;


/**
 * @Author ltl
 * @Date 2020/7/17  18:15
 * @Description 菜单管理
 **/
@Service
public class MenuService extends BaseService<Menu> {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * @Author LTL
     * @Description 通过菜单ID 查询菜单名称
     * @Param [id]
     * @Return java.lang.String
     * @DateTime 2020/7/17  22:20
     * @Throws
     */
    public Menu selectMenuById(Long id) {
        Menu menu = null;
        try {
            menu = menuMapper.selectOne(new Menu().setMenuId(id));
            return menu;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author LTL
     * @Description 通过用户ID查询用户所拥有的权限
     * @Param [userId, roleService, roleMenuService]
     * @Return java.util.List<com.aaa.cehui.model.Menu>
     * @DateTime 2020/7/18  16:15
     * @Throws
     */
    public List<Menu> selectMenuByUserId(User user, UserRoleService userRoleService, RoleMenuService roleMenuService) {
        List<Menu> menuList = new ArrayList<>();
        //获取用户的id来查询所拥有的权限信息
        UserRole userRole = userRoleService.selectOne(new UserRole().setUserId(user.getId()));
        //拿到用户所拥有的角色信息,通过角色ID 去查该角色所拥有的权限
        //使用的是t_role_menu中间表
        //返回的是该用户所拥有的权限id集合
        List<RoleMenu> roleMenus = roleMenuService.selectList(new RoleMenu().setRoleId(userRole.getRoleId()));
        for (int i = 0; i < roleMenus.size(); i++) {
            try {
                menuList.add(
                        menuMapper.selectMenuByMenuId(
                                roleMenus.get(i).getMenuId()
                        ).setSubMenu(
                                getSubMenu(roleMenus.get(i).getMenuId(), menuMapper.selectAll())
                        )
                );
            } catch (Exception e) {
                continue;
            }
        }
        if (menuList.size() > 0) {
            return menuList;
        } else {
            return null;
        }

    }

    /**
     * @Author LTL
     * @Description 查询所有菜单列表
     * @Param []
     * @Return java.util.List<com.aaa.cehui.model.Menu>
     * @DateTime 2020/7/18  17:09
     * @Throws
     */
    public List<Menu> selectAllMenus() {
        //菜单树
        List<Menu> menusList = new ArrayList<Menu>();
        //菜单的全部信息
        List<Menu> allMenusList = menuMapper.selectAll();
        if (null != allMenusList && allMenusList.size() > 0) {
            //拿到一级菜单信息
            for (int i = 0; i < allMenusList.size(); i++) {
                Menu menu = allMenusList.get(i);
                if (menu.getParentId() == 0) {
                    //说明是一级菜单
                    menusList.add(menu);
                }
            }
            //为一级菜单设置子菜单
            for (Menu menu : menusList) {
                menu.setSubMenu(getSubMenu(menu.getMenuId(), allMenusList));
            }
        }
        return menusList;
    }

    public PageInfo selectAllMenusByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<Menu> pageInfo = new PageInfo<>(selectAllMenus());
        return pageInfo;
    }

    /**
     * @Author LTL
     * @Description 查询子菜单
     * @Param [menuId, allMenus]
     * @Return java.util.List<com.aaa.cehui.model.Menu>
     * @DateTime 2020/7/18  16:18
     * @Throws
     */
    private List<Menu> getSubMenu(Long menuId, List<Menu> allMenus) {
        //子菜单
        List<Menu> subMenus = new ArrayList<Menu>();
        for (Menu menu : allMenus) {
            if (menu.getParentId().equals(menuId)) {
                subMenus.add(menu);
            }
        }
        //子菜单的下一级
        //当递归进入，查找子菜单的子菜单，子菜单的数据在下面循环代码中的subMenus中
        for (Menu menu : subMenus) {
            menu.setSubMenu(getSubMenu(menu.getMenuId(), allMenus));
        }
        if (subMenus.size() == 0) {
            return null;
        }
        return subMenus;
    }

    /**
     * @Author LTL
     * @Description 通过角色ID查询所有权限
     * @Param [roleId, roleMenuService]
     * @Return java.util.List<com.aaa.cehui.model.Menu>
     * @DateTime 2020/7/18  19:11
     * @Throws
     */
    public List<Menu> getMenuByRoleId(Long roleId, RoleMenuService roleMenuService) {
        List<RoleMenu> roleMenus = null;
        List<Menu> menuList = new ArrayList<>();
        if (null != roleId) {
            try {
                roleMenus = roleMenuService.selectList(new RoleMenu().setRoleId(roleId));
                for (int i = 0; i < roleMenus.size(); i++) {
                    menuList.add(menuMapper.selectMenuByMenuId(roleMenus.get(i).getMenuId()).setSubMenu(getSubMenu(roleId, selectAllMenus())));
                }
            } catch (Exception e) {

            }
            return menuList;
        }
        return null;

    }


    /**
     * @Author LTL
     * @Description 通过id修改菜单信息
     * @Param [menu]
     * @Return java.lang.Integer
     * @DateTime 2020/7/20  21:41
     * @Throws
     */
    public Integer updateMenuByMenuId(Menu menu) {
        menu.setModifyTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
        Integer update = update(menu);
        if (update > 0) {
            return update;
        } else {
            return 0;
        }

    }


    /**
     * @Author LTL
     * @Description 条件查询菜单信息
     * @Param [map]
     * @Return java.util.List<com.aaa.cehui.model.Menu>
     * @DateTime 2020/7/20  22:03
     * @Throws
     */
    public List<Menu> selectMenusByFiled(Map map, Sqls where) {
        Object menuName = map.get("menuName");
        Object beginTime = map.get("beginTime");
        Object endTime = map.get("endTime");
        if (null != menuName && !"".equals(menuName)
                && null != beginTime && !"".equals(beginTime)) {
            //说明是全条件查询
            return selectListByFiled(where.andLike("menuName", menuName.toString()).andBetween("createTime", beginTime, endTime), null);
        } else if (null != menuName && !"".equals(menuName)) {
            //说明单条件，通过名称查询
            return selectListByFiled(where.andLike("menuName", menuName.toString()), null);
        } else if (null != beginTime && !"".equals(beginTime)) {
            //说明是单条件查询
            return selectListByFiled(where.andBetween("createTime", beginTime, endTime), null);
        }
        return null;
    }

}
