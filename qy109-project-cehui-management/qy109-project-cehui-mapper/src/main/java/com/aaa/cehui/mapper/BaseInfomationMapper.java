package com.aaa.cehui.mapper;

import com.aaa.cehui.model.Mapping_unit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseInfomationMapper extends Mapper<Mapping_unit> {

    List<Mapping_unit> qureyMapping_unit(Long userId);

    /**
     * @author ligen
     * @description
     *  模糊查询 查询测绘单位名称
     * @date 2020/5/26
     * @param [mappingUnit]
     * @return java.util.List<com.aaa.xj.model.MappingUnit>
     */
    List<Mapping_unit> fuzzyUnitName(@Param("unitName") String unitName,
                                     @Param("ownedDistrict") String ownedDistrict,
                                     @Param("qualificationLevel") String qualificationLevel);










}