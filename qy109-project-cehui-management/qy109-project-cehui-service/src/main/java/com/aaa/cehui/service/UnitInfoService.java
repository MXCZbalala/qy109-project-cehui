package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.mapper.BaseInfomationMapper;
import com.aaa.cehui.model.Mapping_unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/16  20:01
 * @Description
 *      测绘管理--单位基本信息
 **/
@Service
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

    /**
     * 查询白名单
     * @return
     */
    public List<Mapping_unit> queryBaiMingDanByScore(){

        return baseInfomationMapper.queryBaiMingDanByScore();
    };

    /**
     * 查询黑名单
     * @return
     */
    public List<Mapping_unit> queryHeiMingDanByScore(){

        return baseInfomationMapper.queryHeiMingDanByScore();
    };

}
