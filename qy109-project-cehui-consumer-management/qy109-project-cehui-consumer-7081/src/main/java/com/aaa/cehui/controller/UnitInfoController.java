package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/27  19:04
 * @Description
 **/
@RestController
@Api(value = "基本单位信息", tags = "基本单位信息")
public class UnitInfoController {
    @Autowired
    private MappingApiService mappingApiService;

    /**
     * @Author LTL
     * @Description 根据登录账号查询所属单位基本信息
     * @Param [id]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  20:10
     * @Throws
     */
    @PostMapping("/selectUnitInfoById")
    public ResultData selectUnitInfoById(@RequestParam("id") Long id){
        return mappingApiService.selectUnitInfoById(id);
    }
}
