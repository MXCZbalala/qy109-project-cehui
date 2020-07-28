package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.SpecialPost;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/27  18:54
 * @Description
 **/
@RestController
@Api(value = "特殊岗位人员", tags = "特殊岗位人员信息")
public class SpecialPostController {

    @Autowired
    private MappingApiService mappingApiService;

    /**
     * @Author LTL
     * @Description 分页查询所有的技术人员信息
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:35
     * @Throws
     */
    @GetMapping("/selectAllSpecialPost")
    public ResultData selectAllSpecialPost(@RequestParam("pageNo") Integer pageNo,
                                           @RequestParam("pageSize") Integer pageSize
    ){
        return mappingApiService.selectAllSpecialPost(pageNo, pageSize);
    }

    /**
     * @Author LTL
     * @Description 添加一条技术人员信息
     * @Param [specialPost]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:35
     * @Throws
     */
    @PostMapping("/addSpecialPost")
    public ResultData addSpecialPost(SpecialPost specialPost){
        return mappingApiService.addSpecialPost(specialPost);
    }

    /**
     * @Author LTL
     * @Description 通过主键删除技术人员信息
     * @Param [specialPost]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:36
     * @Throws
     */
    @PostMapping("/deleteSpecialPostById")
    public ResultData deleteSpecialPostById(SpecialPost specialPost){
        return mappingApiService.deleteSpecialPostById(specialPost);
    }

    /**
     * @Author LTL
     * @Description 通过主键修改技术人员信息
     * @Param [specialPost]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:36
     * @Throws
     */
    @PostMapping("/updateSpecialPostById")
    public ResultData updateSpecialPostById(SpecialPost specialPost){
        return mappingApiService.updateSpecialPostById(specialPost);
    }

    /**
     * 通过userId查询特殊岗位人员
     * @param userId
     * @return
     */
    @PostMapping("/queryByUserId")
    @ApiOperation(value = "通过userId查询所有特殊人员信息",
            notes = "通过发送userId参数来查询所有特殊人员信息")
    public ResultData queryByUserId(@RequestParam("userId") Integer userId){
        return mappingApiService.queryByUserId(userId);
    }


}
