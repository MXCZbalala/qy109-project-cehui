package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Dict;
import com.aaa.cehui.service.SystemApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/27  11:12
 * @Description
 **/
@RestController
@Api(value = "字典管理", tags = "字典表")
public class DictController {

    @Autowired
    private SystemApiService systemApiService;

    /**
     * @Description: 查询所有字典信息
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/16
     */
    @PostMapping("/queryAllDict")
    @ApiOperation(value = "查询字典信息",
            notes = "查询所有的字典信息")
    public ResultData selectDict(){
        return systemApiService.selectDict();
    }

    /**
     * @Description: 新增字典信息
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/16
     */
    @PostMapping("/addDict")
    @ApiOperation(value = "新增字典信息",
            notes = "通过发送实体类参数来新增字典信息")
    public ResultData addDict(Dict dict){
        return addDict(dict);
    }

    /**
     * @Description: 通过主键批量删除字典数据
     * @Param: [dictIds]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/16
     */
    @PostMapping("/deleteDict")
    @ApiOperation(value = "批量删除字典信息",
            notes = "通过发送list集合参数批量删除字典信息")
    public ResultData deleteDict(@RequestParam("dictIds") List<Integer> dictIds){
        return systemApiService.deleteDict(dictIds);
    }

    /**
     * @Description: 查询出需要修改的数据
     * @Param: [dictId]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/16
     */
    @PostMapping("/selectUpdateDict")
    @ApiOperation(value = "查询需要修改字典信息的id",
            notes = "通过发送来的id来查询需要修改的字典信息")
    public ResultData selectUpdateDict(@RequestParam("dictId") Long dictId){
        return selectUpdateDict(dictId);
    }

    /**
     * @Description: 修改查询出来的信息
     * @Param: [dict]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/16
     */
    @PostMapping("/updateDict")
    @ApiOperation(value = "修改字典信息",
            notes = "通过发送实体类参数来修改字典信息")
    public ResultData updateDict(Dict dict){
        return updateDict(dict);
    }

    /**
     * @Description: 字典的分页查询信息
     * @Param: [dict, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/16
     */
    @PostMapping("/selectDictByPage")
    @ApiOperation(value = "分页查询字典信息",
            notes = "通过发送pageNo和pageSize来分页查询字典信息")
    public ResultData selectDictByPage(@RequestBody Dict dict,
                                       @RequestParam("pageNo") Integer pageNo,
                                       @RequestParam("pageSize") Integer pageSize){
        return selectDictByPage(dict, pageNo, pageSize);
    }



}
