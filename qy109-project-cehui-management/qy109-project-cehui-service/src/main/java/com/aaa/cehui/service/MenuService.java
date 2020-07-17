package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.MenuMapper;
import com.aaa.cehui.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public String selectMenuNameById(Integer id) {

        String menuName = "";

        try {
            menuName = menuMapper.selectOne(new Menu().setMenuId(id)).getMenuName();
            return menuName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
