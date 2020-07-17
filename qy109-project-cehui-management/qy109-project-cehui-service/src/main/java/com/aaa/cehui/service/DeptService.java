package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.DeptMapper;
import com.aaa.cehui.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author ltl
 * @Date 2020/7/16  15:40
 * @Description
 **/
@Service
public class DeptService extends BaseService<Dept> {

    @Autowired
    DeptMapper deptMapper;

    /**
    * @Author LTL
    * @Description 查询-动态sql查询条件：部门名称 创建时间区间
    * @Param [map]
    * @Return java.util.List<com.aaa.cehui.model.Dept>
    * @DateTime 2020/7/16  17:31
    * @Throws
    */
    public List<Dept> selectDeptInfoByField(Map map) {
        List<Dept> deptList = null;
        try {
            // 调用 deptMapper 中的 selectDeptInfoByField 方法，根据条件查询部门信息
            deptList = deptMapper.selectDeptInfoByField(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 判断 结果是否为空
        if(null != deptList && deptList.size() > 0){
            // 查询成功，返回 查询的部门信息
            return deptList;
        }else {
            // 查询失败，返回null
            return null;
        }
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
            }else {
                // 删除失败，返回false
                return false;
            }
        }else {
            // 前端传参失败，返回false 删除失败
            return false;
        }
    }

}
