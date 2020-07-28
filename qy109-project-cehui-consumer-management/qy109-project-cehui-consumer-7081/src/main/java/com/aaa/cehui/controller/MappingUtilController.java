package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.MappingUnit;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "查询所有白名单信息",
            notes = "无参数来查询白名单信息")
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
    @ApiOperation(value = "分页查询所有白名单信息",
            notes = "通过当前页面和页面条数参数来查询白名单信息")
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
    @ApiOperation(value = "查询所有黑名单信息",
            notes = "无参数来查询黑名单信息")
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
    @ApiOperation(value = "分页查询所有黑名单信息",
            notes = "通过当前页面和页面条数参数来查询黑名单信息")
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
    @ApiOperation(value = "查询所有单位信息",
            notes = "无参数来查询所有单位信息")
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
    @ApiOperation(value = "分页查询所有单位信息",
            notes = "通过当前页面和页面条数参数来查询所有单位信息")
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
    @ApiOperation(value = "根据单位名称模糊查询单位信息",
            notes = "通过单位名称参数来查询单位信息")
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
    @ApiOperation(value = "分页查询所有未检测单位信息",
            notes = "通过同步状态码和当前页面和页面条数参数来分页查询所有未检测单位信息")
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
    @ApiOperation(value = "修改所有单位信息",
            notes = "通过发送实体类参数来修改所有单位信息")
    public ResultData updateMappingUnit(MappingUnit mapping_unit){
        return mappingApiService.updateMappingUnit(mapping_unit);
    }


}
