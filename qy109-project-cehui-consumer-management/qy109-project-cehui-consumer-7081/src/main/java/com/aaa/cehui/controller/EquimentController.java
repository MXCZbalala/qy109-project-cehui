package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.service.MappingApiService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/27  11:31
 * @Description
 **/
@RestController
@Api(value = "设备管理", tags = "设备信息")
public class EquimentController {

    @Autowired
    private MappingApiService mappingApiService;


    /**
     * @Author LTL
     * @Description 分页查询所有设备仪器信息
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/17  9:50
     * @Throws
     */
    @GetMapping("/selectAllEquiment")
    public PageInfo selectAllEquiment(@RequestParam("pageNo") Integer pageNo,
                                      @RequestParam("pageSize")Integer pageSize
    ){
        return mappingApiService.selectAllEquiment(pageNo, pageSize);
    }

    /**
     * 通过userID查询设备信息分页
     * @param userId
     * @param pageNo
     * @param pageSize
     * @param
     * @return
     */
    @PostMapping("/queryEquimentByUserIdPage")
    @ApiOperation(value = "通过userId分页查询所有设备信息",
            notes = "通过发送userId和当前页面和叶面条数参数来分页查询所有设备信息")
    public ResultData queryByUserIdPage(@RequestParam("userId") Integer userId,
                                        @RequestParam("pageNo") Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize
    ){
        return mappingApiService.queryByUserIdPage(userId, pageNo, pageSize);
    }


}
