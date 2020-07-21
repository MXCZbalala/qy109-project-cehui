package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Mapping_unit;
import com.aaa.cehui.service.UnitInfoService;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @author sbs
 * @date 2020/7/18 16:12
 */
@RestController
public class MappingUtilController extends CommonController<Mapping_unit> {
    @Autowired
    private UnitInfoService unitInfoService;
    @Override
    public BaseService<Mapping_unit> getBaseService() {
        return unitInfoService;
    }

    /**
     * 白名单查询
     * @return
     */
    @PostMapping("/queryBaiMingDan")
    public List<Mapping_unit> selectBaiByScore(){
        return unitInfoService.queryBaiMingDanByUnitStatus();
    }

    /**
     * 白名单分页查询
     * @param
     * @param pageNo
     * @param pageSize
     * @param where
     * @return
     */
    @PostMapping("/queryBaiMingDanPage")
    public ResultData queryBaiMingDan(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize")Integer pageSize ,Sqls where){
        Integer unitStatus=1;
        PageInfo<Mapping_unit> resultMapping = getBaseService().selectListByPageAndFiled(pageNo, pageSize, where.andEqualTo("unitStatus", unitStatus), null, null);
        if (resultMapping != null) {
            return getSuccess(resultMapping);
        }else {
            return getFiled();
        }
    }

    /**
     * 黑名单查询
     * @return
     */
    @PostMapping("/queryHeiMingDan")
    public List<Mapping_unit> selectHeiByScore(){
        return unitInfoService.queryHeiMingDanByUnitStatus();
    }

    /**
     * 黑名单分页查询
     * @param
     * @param pageNo
     * @param pageSize
     * @param where
     * @return
     */
    @PostMapping("/queryHeiMingDanPage")
    public ResultData queryHeiMingDan(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize")Integer pageSize ,Sqls where){
        Integer unitStatus=2;
        PageInfo<Mapping_unit> resultMapping = getBaseService().selectListByPageAndFiled(pageNo, pageSize, where.andEqualTo("unitStatus", unitStatus), null, null);
        if (resultMapping != null) {
            return getSuccess(resultMapping);
        }else {
            return getFiled();
        }
    }
    /**
     * 查询所有单位信息
     * @return
     */
    @PostMapping("/selectAllMappingUtil")
    public List<Mapping_unit> selectAllMappingUtil(){
        return unitInfoService.selectAllMappingUtil();
    }

    /**
     * 查询所有单位信息分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/selectAllMappingUtilPage")
    public ResultData selectAllMappingUtilPage(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        List<Mapping_unit> mapping_units = getBaseService().selectAll(pageNo, pageSize);
        if (mapping_units != null) {
            return getSuccess(mapping_units);
        }else{
            return getFiled();
        }
    }

    /**
     * 根据单位名称模糊查询单位信息
     * @param name
     * @return
     */
    @PostMapping("/queryAllMappingUtilByName")
    public ResultData queryAllMappingUtilByName(@RequestParam("name") String name){
        List<Mapping_unit> mapping_units = unitInfoService.queryAllMappingUtilByName(name);
        if (mapping_units != null) {
            return getSuccess(mapping_units);
        }else{
            return getFiled();
        }
    }

    /**
     * 分页查询所有未检测单位信息
     * @param
     * @param pageNo
     * @param pageSize
     * @param where
     * @return
     */
    @PostMapping("/queryMappingUtilByStatus")
    public  ResultData queryMappingUtilBySyzStatus(@RequestParam("synchronizationStatus")Integer synchronizationStatus, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize")Integer pageSize, Sqls where){
        PageInfo<Mapping_unit> resultMappingUtil = getBaseService().selectListByPageAndFiled(pageNo, pageSize, where.andEqualTo("synchronizationStatus", synchronizationStatus), null, null);

        if (resultMappingUtil !=null) {
            return getSuccess(resultMappingUtil);
        }else {
            return getFiled();
        }
    }

    /**
     * 修改单位信息
     * @param mapping_unit
     * @return
     */
    @PostMapping("/updateMappingUnit")
    public ResultData updateMappingUnit(Mapping_unit mapping_unit){
        Integer resultMappingUnit = getBaseService().update(mapping_unit);
        if (resultMappingUnit != null) {
            return getSuccess(resultMappingUnit);
        }else {
            return getFiled();
        }
    }
}
