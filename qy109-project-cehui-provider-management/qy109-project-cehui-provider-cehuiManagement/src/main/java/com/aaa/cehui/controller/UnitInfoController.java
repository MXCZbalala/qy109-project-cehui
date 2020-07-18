package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Mapping_unit;
import com.aaa.cehui.service.UnitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/16  19:58
 * @Description
 *              测绘管理--单位基本信息
 **/
@RestController
public class UnitInfoController extends CommonController<Mapping_unit> {

    @Autowired
    private UnitInfoService unitInfoService;

    @Override
    public BaseService<Mapping_unit> getBaseService() {
        return unitInfoService;
    }

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
        if (null != unitInfoService.selectUnitInfoById(id)){
            return super.getSuccess(unitInfoService.selectUnitInfoById(id));
        }else {
           return getFiled();
        }
    }


}
