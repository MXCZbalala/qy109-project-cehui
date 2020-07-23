package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Dept;
import com.aaa.cehui.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.Sqls;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author ltl
 * @Date 2020/7/16  15:39
 * @Description 系统管理--部门管理
 **/
@RestController
public class DeptController extends CommonController<Dept> {

    @Autowired
    private DeptService deptService;

    @Override
    public BaseService getBaseService() {
        return deptService;
    }

    /**
     * @Author LTL
     * @Description 新增部门
     * @Param [dept]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  15:55
     * @Throws
     */
    @PostMapping("/addDept")
    public ResultData addDept(@RequestBody Dept dept) {
        return deptService.add(dept) > 0 ? updateSuccess() : updateFiled();
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
        return deptService.delete(dept) > 0 ? updateSuccess() : updateFiled();
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
        return deptService.update(dept) > 0 ? updateSuccess() : updateFiled();
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
                                    @RequestParam("pageSize") Integer pageSize) {
        return deptService.selectAll(pageNo, pageSize).size() > 0 ? getSuccess(deptService.selectAll(pageNo, pageSize)) : getFiled();
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
        return deptService.selectDeptInfoByField(map, pageNo, pageSize).getSize() > 0 ? getSuccess(deptService.selectDeptInfoByField(map, pageNo, pageSize)) : getFiled("未查询到数据");

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
    public ResultData batchDeleteByPrimaryKey(@RequestParam("ids[]") List<Integer> ids) {
        return deptService.batchDeleteByPrimaryKey(ids) ? deleteSuccess() : deleteSuccess();
    }

}
