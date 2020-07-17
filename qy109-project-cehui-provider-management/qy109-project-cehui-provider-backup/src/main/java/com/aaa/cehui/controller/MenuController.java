package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Menu;
import com.aaa.cehui.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/17  22:46
 * @Description
 **/
@RestController
public class MenuController extends CommonController<Menu> {
    @Autowired
    private MenuService menuService;
    public BaseService<Menu> getBaseService() {
        return menuService;
    }

    /**
    * @Author LTL
    * @Description 修改菜单信息
    * @Param [menu]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/17  22:48
    * @Throws
    */
    @PostMapping("/updateMenu")
    public ResultData updateMenu(@RequestBody Menu menu){
        Integer update = getBaseService().update(menu);
        if (update>0){
            return updateSuccess(update);
        }else {
            return updateFiled();
        }
    }
}
