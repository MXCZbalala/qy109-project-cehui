package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.DeptMapper;
import com.aaa.cehui.model.Dept;
import com.aaa.cehui.model.Menu;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Delayed;

/**
 * @Author ltl
 * @Date 2020/7/16  15:40
 * @Description
 **/
@Service
public class DeptService extends BaseService<Dept> {

    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> selectAllDept(Integer pageNo, Integer pageSize) {
        List<Dept> deptList = new ArrayList<>();
        List<Dept> allDeptList = deptMapper.selectAll();
        if (null != allDeptList && allDeptList.size() > 0) {

            for (int i = 0; i < allDeptList.size(); i++) {
                Dept dept = allDeptList.get(i);
                if (dept.getParentId() == 0) {
                    //说明是一级菜单
                    deptList.add(dept);
                }
            }
            //为一级菜单设置子菜单
            for (Dept dept : deptList) {
                dept.setChildren(getChildrenDept(dept.getDeptId(), allDeptList));
            }
        }
        return deptList;
    }

    private List<Dept> getChildrenDept(Integer deptId, List<Dept> allDepts) {
        //子菜单
        List<Dept> childrenDept = new ArrayList<Dept>();
        for (Dept dept : allDepts) {
            if (dept.getParentId().equals(deptId)) {
                childrenDept.add(dept);
            }
        }
        //子菜单的下一级
        //当递归进入，查找子菜单的子菜单，子菜单的数据在下面循环代码中的subMenus中
        for (Dept dept : childrenDept) {
            dept.setChildren(getChildrenDept(dept.getDeptId(), allDepts));
        }
        if (childrenDept.size() == 0) {
            return null;
        }
        return childrenDept;
    }


    /**
     * @Author LTL
     * @Description 查询-动态sql查询条件：部门名称 创建时间区间
     * @Param [map]
     * @Return java.util.List<com.aaa.cehui.model.Dept>
     * @DateTime 2020/7/16  17:31
     * @Throws
     */
    public PageInfo selectDeptInfoByField(Map map, Integer pageNo, Integer pageSize) {
        Sqls where = Sqls.custom();
        Object deptName = map.get("deptName");
        Object beginTime = map.get("beginTime");
        Object endTime = map.get("endTime");
        if (null != deptName && !"".equals(deptName)
                && null != beginTime && !"".equals(beginTime)) {
            //说明全条件查询
            System.out.println("全条件查询");
            return selectListByPageAndFiled(pageNo, pageSize, where.andLike("deptName", "%"+deptName.toString()+"%").andBetween("createTime", beginTime, endTime), null);
        } else if (null != deptName && !"".equals(deptName)) {
            //说明单条件查询  通过deptname
            System.out.println("单条件查询通过部门名称");
            return selectListByPageAndFiled(pageNo, pageSize, where.andLike("deptName", "%"+deptName.toString()+"%"), null);
        } else if (null != beginTime && !"".equals(beginTime)) {
            //说明单条件查询，通过区间时间
            System.out.println("时间区间单条件查询");
            return selectListByPageAndFiled(pageNo, pageSize, where.andBetween("createTime", beginTime, endTime), null);
        }
        return null;
    }

    /**
     * @Author LTL
     * @Description 根据主键批量删除
     * @Param [ids]
     * @Return java.lang.Boolean
     * @DateTime 2020/7/16  17:37
     * @Throws
     */
    public Boolean batchDeleteByPrimaryKey(List<Integer> ids) {
        // 判断 前端传值是否为空
        if (null != ids && !"".equals(ids)) {
            Integer batchDelete = null;

            try {
                // 调用父类的批量删除方法
                batchDelete = super.deleteByIds(ids);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 判断 受影响行数是否大于0，删除是否成功
            if (batchDelete > 0) {
                // 删除成功，返回true
                return true;
            } else {
                // 删除失败，返回false
                return false;
            }
        } else {
            // 前端传参失败，返回false 删除失败
            return false;
        }
    }


}
