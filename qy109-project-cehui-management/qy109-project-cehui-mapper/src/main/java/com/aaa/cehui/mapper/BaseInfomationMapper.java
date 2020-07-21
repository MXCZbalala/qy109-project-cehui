package com.aaa.cehui.mapper;

import com.aaa.cehui.model.Mapping_unit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseInfomationMapper extends Mapper<Mapping_unit> {

    Mapping_unit qureyMapping_unit(Long userId);

    /**
    * @Author LTL
    * @Description 模糊查询 查询测绘单位名称
    * @Param [unitName, ownedDistrict, qualificationLevel]
    * @Return java.util.List<com.aaa.cehui.model.Mapping_unit>
    * @DateTime 2020/7/14  11:23
    * @Throws
    */
    List<Mapping_unit> fuzzyUnitName(@Param("unitName") String unitName,
                                     @Param("ownedDistrict") String ownedDistrict,
                                     @Param("qualificationLevel") String qualificationLevel);





    /**
     * 查询白名单
     * @return
     */
    List<Mapping_unit> queryBaiMingDanByUnitStatus();

    /**
     * 查询黑名单
     * @return
     */
    List<Mapping_unit> queryHeiMingDanByUnitStatus();

    /**
     * 查询所有单位信息
     * @return
     */
    List<Mapping_unit> selectAllMappingUtil();

    List<Mapping_unit> queryAllMappingUtilByName(String name);

    int updateScoreAndStatusById(Mapping_unit mapping_unit);
}