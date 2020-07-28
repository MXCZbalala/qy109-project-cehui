package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Principal;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/27  16:57
 * @Description
 **/
@RestController
@Api(value = "负责人信息")
public class PrincipalController {
    @Autowired
    private MappingApiService mappingApiService;


    /**
     * @Author LTL
     * @Description 通过ID查询单个负责人信息
     * @Param [principal]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  21:56
     * @Throws
     */
    @PostMapping("/selectPricipalById")
    public ResultData selectPricipalById(Principal principal){
        return mappingApiService.selectPricipalById(principal);
    }

    /**
     * @Author LTL
     * @Description 分页查询所有负责人信息
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:33
     * @Throws
     */
    @PostMapping("/selectAllPricipal")
    public ResultData selectAllPricipal(@RequestParam("pageNo") Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize
    ){
        return mappingApiService.selectAllPricipal(pageNo, pageSize);
    }

    /**
     * @Author LTL
     * @Description 增加一个负责人信息
     * @Param [principal]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:33
     * @Throws
     */
    @PostMapping("/addPricipal")
    public ResultData addPricipal(Principal principal){
        return mappingApiService.addPricipal(principal);
    }


    /**
     * @Author LTL
     * @Description 修改单个负责人信息
     * @Param [principal]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:33
     * @Throws
     */
    @PostMapping("/updatePricipal")
    public ResultData updatePricipal(Principal principal){
        return mappingApiService.updatePricipal(principal);
    }

    /**
     * @Author LTL
     * @Description 删除单个负责人信息
     * @Param [principal]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:33
     * @Throws
     */
    @PostMapping("/deletePricipal")
    public ResultData deletePricipal(Principal principal){
        return mappingApiService.deletePricipal(principal);
    }

    /**
     * 根据userId查询负责人信息
     * @param
     * @return
     */
    @PostMapping("/queryPrincipalByUserId")
    @ApiOperation(value = "通过userId查询负责人信息",
            notes = "通过发送userId和当前页面和叶面条数参数来查询负责人信息")
    public List<Principal> selectByUserId(@RequestParam("userId")Integer userId
    ){
        return mappingApiService.selectByUserId(userId);
    }


}
