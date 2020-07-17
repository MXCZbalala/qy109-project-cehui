package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.mapper.BaseInfomationMapper;
import com.aaa.cehui.model.Mapping_unit;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author ltl
 * @Date 2020/7/16  20:01
 * @Description
 *      测绘管理--单位基本信息
 **/
public class UnitInfoService extends BaseService<Mapping_unit> {
    @Autowired
    BaseInfomationMapper baseInfomationMapper;

    /**
    * @Author LTL
    * @Description 通过ID查询单位信息
    * @Param [id]
    * @Return com.aaa.cehui.model.Mapping_unit
    * @DateTime 2020/7/16  21:49
    * @Throws
    */
    public Mapping_unit selectUnitInfoById(Long id){
         return baseInfomationMapper.qureyMapping_unit(id);
    }


}
