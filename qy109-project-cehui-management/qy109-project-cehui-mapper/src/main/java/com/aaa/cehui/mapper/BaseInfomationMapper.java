package com.aaa.cehui.mapper;

import com.aaa.cehui.model.MappingUnit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseInfomationMapper extends Mapper<MappingUnit> {

    MappingUnit qureyMapping_unit(Long userId);

    /**
    * @Author LTL
    * @Description 模糊查询 查询测绘单位名称
    * @Param [unitName, ownedDistrict, qualificationLevel]
    * @Return java.util.List<com.aaa.cehui.model.Mapping_unit>
    * @DateTime 2020/7/14  11:23
    * @Throws
    */
    List<MappingUnit> fuzzyUnitName(@Param("unitName") String unitName,
                                     @Param("ownedDistrict") String ownedDistrict,
                                     @Param("qualificationLevel") String qualificationLevel);





    /**
     * 查询白名单
     * @return
     */
    List<MappingUnit> queryBaiMingDanByUnitStatus();

    /**
     * 查询黑名单
     * @return
     */
    List<MappingUnit> queryHeiMingDanByUnitStatus();

    /**
     * 查询所有单位信息
     * @return
     */
    List<MappingUnit> selectAllMappingUtil();

    List<MappingUnit> queryAllMappingUtilByName(String name);

    int updateScoreAndStatusById(MappingUnit mapping_unit);
    List<MappingUnit> selectPartUnitByPage(String ownedDistrict);
}