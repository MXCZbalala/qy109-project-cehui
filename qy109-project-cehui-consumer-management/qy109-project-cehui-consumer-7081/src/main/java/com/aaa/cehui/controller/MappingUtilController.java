package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.MappingUnit;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/27  16:46
 * @Description
 **/
@RestController
@Api(value = "单位管理", tags = "单位信息")
public class MappingUtilController {
    @Autowired
    private MappingApiService mappingApiService;


    /**
     * 白名单查询
     * @return
     */
    @PostMapping("/queryBaiMingDan")
    public List<MappingUnit> selectBaiByScore(){
        return mappingApiService.selectBaiByScore();
    }

    /**
     * 白名单分页查询
     * @param
     * @param pageNo
     * @param pageSize
     * @param
     * @return
     */
    @PostMapping("/queryBaiMingDanPage")
    public ResultData queryBaiMingDan(@RequestParam("pageNo") Integer pageNo,
                                      @RequestParam("pageSize")Integer pageSize
    ){
        return mappingApiService.queryBaiMingDan(pageNo, pageSize);
    }

    /**
     * 黑名单查询
     * @return
     */
    @PostMapping("/queryHeiMingDan")
    public List<MappingUnit> selectHeiByScore(){
        return mappingApiService.selectHeiByScore();
    }

    /**
     * 黑名单分页查询
     * @param
     * @param pageNo
     * @param pageSize
     * @param
     * @return
     */
    @PostMapping("/queryHeiMingDanPage")
    public ResultData queryHeiMingDan(@RequestParam("pageNo") Integer pageNo,
                                      @RequestParam("pageSize")Integer pageSize
    ){
        return mappingApiService.queryHeiMingDan(pageNo, pageSize);
    }

    /**
     * 查询所有单位信息
     * @return
     */
    @PostMapping("/selectAllMappingUtil")
    public List<MappingUnit> selectAllMappingUtil(){
        return mappingApiService.selectAllMappingUtil();
    }

    /**
     * 查询所有单位信息分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/selectAllMappingUtilPage")
    public ResultData selectAllMappingUtilPage(@RequestParam("pageNo") Integer pageNo,
                                               @RequestParam("pageSize") Integer pageSize
    ){
        return mappingApiService.selectAllMappingUtilPage(pageNo, pageSize);
    }

    /**
     * 根据单位名称模糊查询单位信息
     * @param name
     * @return
     */
    @PostMapping("/queryAllMappingUtilByName")
    public ResultData queryAllMappingUtilByName(@RequestParam("name") String name){
        return mappingApiService.queryAllMappingUtilByName(name);
    }

    /**
     * 分页查询所有未检测单位信息
     * @param
     * @param pageNo
     * @param pageSize
     * @param
     * @return
     */
    @PostMapping("/queryMappingUtilByStatus")
    public  ResultData queryMappingUtilBySyzStatus(@RequestParam("synchronizationStatus")Integer synchronizationStatus,
                                                   @RequestParam("pageNo") Integer pageNo,
                                                   @RequestParam("pageSize")Integer pageSize
    ){
        return mappingApiService.queryMappingUtilBySyzStatus(synchronizationStatus, pageNo, pageSize);
    }

    /**
     * 修改单位信息
     * @param mapping_unit
     * @return
     */
    @PostMapping("/updateMappingUnit")
    public ResultData updateMappingUnit(MappingUnit mapping_unit){
        return mappingApiService.updateMappingUnit(mapping_unit);
    }


}
