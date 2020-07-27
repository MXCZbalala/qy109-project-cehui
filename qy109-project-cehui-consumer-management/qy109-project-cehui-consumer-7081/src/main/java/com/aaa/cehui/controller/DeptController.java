package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Dept;
import com.aaa.cehui.service.SystemApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author ltl
 * @Date 2020/7/27  11:09
 * @Description
 **/
@RestController
@Api(value = "部门信息", tags = "部门管理")
public class DeptController {

    @Autowired
    private SystemApiService systemApiService;


    /**
     * @Author LTL
     * @Description 新增部门
     * @Param [dept]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  15:55
     * @Throws
     */
    @PostMapping("/addDept")
    @ApiOperation(value = "新增部门信息",
            notes = "通过发送实体类参数来新增部门信息")
    public ResultData addDept(@RequestBody Dept dept){
        return systemApiService.addDept(dept);
    }

    /**
     * @Author LTL
     * @Description 通过ID删除部门信息
     * @Param [dept]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  15:55
     * @Throws
     */
    @PostMapping("/deleteDeptById")
    public ResultData deleteDeptById(@RequestParam Dept dept) {
        return systemApiService.deleteDeptById(dept);
    }

    /**
     * @Author LTL
     * @Description 修改部门信息
     * @Param [dept]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  15:54
     * @Throws
     */
    @PostMapping("/updateDept")
    public ResultData updateDept(@RequestBody Dept dept) {
        return systemApiService.deleteDeptById(dept);
    }

    /**
     * @Author LTL
     * @Description 分页查询所有部门信息
     * @Param []
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  15:55
     * @Throws
     */
    @GetMapping("/selectAllDept")
    public ResultData selectAllDept(@RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize){
        return systemApiService.selectAllDept(pageNo,pageSize);
    }


    /**
     * @Author LTL
     * @Description 查询-动态sql查询条件：部门名称 创建时间区间
     * @Param [map]
     * @Return java.util.List<com.aaa.cehui.model.Dept>
     * @DateTime 2020/7/16  17:32
     * @Throws
     */
    @PostMapping("/selectDeptInfoByField")
    public ResultData selectDeptInfoByField(@RequestBody Map map,
                                            @RequestParam("pageNo") Integer pageNo,
                                            @RequestParam("pageSize") Integer pageSize) {
        return systemApiService.selectDeptInfoByField(map, pageNo, pageSize);
    }

    /**
     * @Author LTL
     * @Description 批量删除
     * @Param [ids]
     * @Return java.lang.Boolean
     * @DateTime 2020/7/16  17:36
     * @Throws
     */
    @PostMapping("/batchDeleteByPrimaryKey")
    public ResultData batchDeleteByPrimaryKey(@RequestParam("ids[]") List<Integer> ids){
        return systemApiService.batchDeleteByPrimaryKey(ids);
    }
}
