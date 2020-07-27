package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.MappingUnit;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/27  19:02
 * @Description
 **/
@RestController
@Api(value = "单位抽查", tags = "单位抽查")
public class UnitAuditController {
    @Autowired
    private MappingApiService mappingApiService;

    /**
     * @Description: 分页查询单位抽查
     * @Param: [mappingUnit, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/selectUnitByPage")
    public ResultData selectUnitByPage(MappingUnit mappingUnit,
                                       @RequestParam("pageNo") Integer pageNo,
                                       @RequestParam("pageSize") Integer pageSize
    ) {
        return mappingApiService.selectUnitByPage(mappingUnit, pageNo, pageSize);
    }

    /**
     * @Description: 分页通过抽查比例查询单位信息
     * @Param: [ownedDistrict, put, mappingUnit, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/selectPartUnitByPage")
    public ResultData selectPartUnitByPage(@RequestBody MappingUnit mappingUnit,
                                           @RequestParam(value = "ownedDistrict") String ownedDistrict,
                                           @RequestParam("put") Double put,
                                           @RequestParam("pageNo") Integer pageNo,
                                           @RequestParam("pageSize") Integer pageSize) {
        return mappingApiService.selectPartUnitByPage(mappingUnit, ownedDistrict, put, pageNo, pageSize);

    }

}
