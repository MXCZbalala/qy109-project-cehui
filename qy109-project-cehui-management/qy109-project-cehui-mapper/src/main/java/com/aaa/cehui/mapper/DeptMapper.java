package com.aaa.cehui.mapper;


import com.aaa.cehui.model.Dept;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface DeptMapper extends Mapper<Dept> {

    /**
    * @Author LTL
    * @Description 查询部门信息，根据主键id查询部门的信息
    * @Param [deptId]
    * @Return com.aaa.cehui.model.Dept
    * @DateTime 2020/7/16  8:38
    * @Throws
    */
    Dept selectDeptByDeptId(Integer deptId);


    /**
    * @Author LTL
    * @Description 查询所有的部门
    * @Param [parentId]
    * @Return java.util.List<com.aaa.cehui.model.Dept>
    * @DateTime 2020/7/16  8:38
    * @Throws
    */
    List<Dept> selectDeptByParentId(Integer parentId);


    /**
    * @Author LTL
    * @Description 查询-动态sql查询条件：部门名称 创建时间区间
    * @Param [map]
    * @Return java.util.List<com.aaa.cehui.model.Dept>
    * @DateTime 2020/7/16  8:38
    * @Throws
    */
    List<Dept> selectDeptInfoByField(Map map);
    

    /**
    * @Author LTL
    * @Description 新增部门信息
    * @Param [dept]
    * @Return int
    * @DateTime 2020/7/16  8:39
    * @Throws
    */
    int insertDept(Dept dept);


}