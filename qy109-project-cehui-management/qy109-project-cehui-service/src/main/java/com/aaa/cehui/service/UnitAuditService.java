package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.BaseInfomationMapper;
import com.aaa.cehui.model.CheckPerson;
import com.aaa.cehui.model.MappingUnit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SqlResultSetMapping;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @program: qy109-project-cehui
 * @description:        测绘管理-->双随机抽查-->单位抽查
 * @author: Mr.Wang
 * @create: 2020-07-21 16:23
 **/
@Service
public class UnitAuditService extends BaseService<MappingUnit> {
    @Autowired
    private BaseInfomationMapper baseInfomationMapper;
    /**
    * @Description: 分页通过抽查比例查询单位信息
    * @Param: [ownedDistrict, put, mappingUnit, pageNo, pageSize]
    * @return: com.github.pagehelper.PageInfo<com.aaa.cehui.model.MappingUnit>
    * @Author: Mr.Wang
    * @Date: 2020/7/21
    */
    public PageInfo<MappingUnit> selectPartUnitByPage(String ownedDistrict, Double put, MappingUnit mappingUnit, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<MappingUnit> mappingUnits = baseInfomationMapper.selectPartUnitByPage(ownedDistrict);
        double a = (double)(mappingUnits.size());
        int v = (int)(a * (put/100));
        List<MappingUnit> lists = new ArrayList<MappingUnit>();
        System.out.println(mappingUnits);
        Collections.shuffle(mappingUnits);
        System.out.println(mappingUnits);
        for (int i = 0; i < v; i++) {
            lists.add(mappingUnits.get(i));
        }
        PageInfo<MappingUnit> pageInfo = new PageInfo<MappingUnit>(lists);
        if (lists.size()>0 && null != lists){
            return pageInfo;
        }
        return null;
    }
}
