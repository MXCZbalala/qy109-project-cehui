package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Dept;
import com.aaa.cehui.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author ltl
 * @Date 2020/7/16  15:39
 * @Description
 **/
@RestController
public class DeptController extends CommonController<Dept> {

    @Autowired
    DeptService deptService;

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
    public ResultData addDept(Dept dept){
        System.out.println(dept.toString());
        Integer add = deptService.add(dept);
        if (add != 0){
            return addSuccess();
        }
        else {
            return addFiled();
        }
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
    public ResultData deleteDeptById(Dept dept){
        Integer delete = deptService.delete(dept);
        if (0 != delete){
            return deleteSuccess();
        }else {
            return deleteFiled();
        }
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
    public ResultData updateDept(Dept dept){
        Integer update = deptService.update(dept);
        if ( 0 !=update){
            return updateSuccess();
        }else {
            return updateFiled();
        }
    }

    /**
    * @Author LTL
    * @Description 查询所有部门信息
    * @Param []
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  15:55
    * @Throws
    */
    @GetMapping("/selectAllDept")
    public ResultData selectAllDept(){
        if (deptService.selectAll().size()>0){
            return getSuccess(deptService.selectAll());
        }else {
            return getFiled();
        }
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
    public List<Dept> selectDeptInfoByField(Map map) {
        // 调用 deptService 中的 selectDeptInfoByField 方法，得到查询结果
        List<Dept> deptList = deptService.selectDeptInfoByField(map);

        // 判断 结果是否为空
        if (deptList != null) {
            // 说明结果不为空，查询成功，返回查询的结果
            return deptList;
        }else {
            // 查询失败，返回null
            return null;
        }
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
    public Boolean batchDeleteByPrimaryKey(List<Integer> ids) {
        // 调用 deptService 中的 batchDeleteByPrimaryKey 方法，得到结果
        Boolean aBoolean = deptService.batchDeleteByPrimaryKey(ids);
        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明结果为true，删除成功 返回true
            return true;
        }else {
            // 删除失败，返回false
            return false;
        }
    }

}
