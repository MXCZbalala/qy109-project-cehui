package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Menu;
import com.aaa.cehui.service.SystemApiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/27  11:16
 * @Description
 **/
@RestController
@Api(value = "菜单信息", tags = "菜单信息")
public class MenuController {
    @Autowired
    private SystemApiService systemApiService;

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
        return updateMenu(menu);
    }
}
