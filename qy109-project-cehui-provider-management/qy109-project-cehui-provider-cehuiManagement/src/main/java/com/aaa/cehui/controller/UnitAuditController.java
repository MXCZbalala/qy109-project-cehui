package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.MappingUnit;
import com.aaa.cehui.service.UnitAuditService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: qy109-project-cehui
 * @description:    测绘管理-->双随机抽查-->单位抽查
 * @author: Mr.Wang
 * @create: 2020-07-21 17:04
 **/
@RestController
public class UnitAuditController extends CommonController<MappingUnit> {
    @Autowired
    private UnitAuditService unitAuditService;
    @Override
    public BaseService<MappingUnit> getBaseService() {
        return unitAuditService;
    }
    /**
    * @Description: 分页查询单位抽查
    * @Param: [mappingUnit, pageNo, pageSize]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/21
    */
    @PostMapping("/selectUnitByPage")
    public ResultData selectUnitByPage(MappingUnit mappingUnit,Integer pageNo,Integer pageSize){
        PageInfo<MappingUnit> mappingUnitPageInfo = unitAuditService.selectListByPage(mappingUnit, pageNo, pageSize);
        if (null!=mappingUnitPageInfo && !"".equals(mappingUnitPageInfo)){
            return getSuccess(mappingUnitPageInfo);
        }
        return getFiled();
    }
    /**
    * @Description: 分页通过抽查比例查询单位信息
    * @Param: [ownedDistrict, put, mappingUnit, pageNo, pageSize]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/21
    */
    @PostMapping("/selectPartUnitByPage")
    public ResultData selectPartUnitByPage(@RequestParam(value = "ownedDistrict",required = false) String ownedDistrict, Double put, MappingUnit mappingUnit, Integer pageNo, Integer pageSize){
        PageInfo<MappingUnit> mappingUnitPageInfo = unitAuditService.selectPartUnitByPage(ownedDistrict, put, mappingUnit, pageNo, pageSize);
        if (null!=mappingUnitPageInfo && !"".equals(mappingUnitPageInfo)){
            return getSuccess(mappingUnitPageInfo);
        }
        return getFiled();
    }
}
