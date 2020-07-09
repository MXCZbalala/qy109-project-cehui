package com.aaa.cehui.mapper;


import com.aaa.cehui.model.Dept;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface DeptMapper extends Mapper<Dept> {

    /**
    * @Author wxz
    * @Description 查询部门信息，根据主键id查询部门的信息
    * @Param
    * @return
    **/
    Dept selectDeptByDeptId(Integer deptId);


    /**
    * @Author wxz
    * @Description 查询所有的部门
    * @Param
    * @return
    **/
    List<Dept> selectDeptByParentId(Integer parentId);


    /**
    * @Author wxz
    * @Description 查询-动态sql查询条件：部门名称 创建时间区间
    * @Param
    * @return
    **/
    List<Dept> selectDeptInfoByField(Map map);
    

    /**
    * @Author wxz
    * @Description 新增部门信息
    * @Param
    * @return
    **/
    int insertDept(Dept dept);


}