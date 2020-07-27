package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.CheckPerson;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/27  11:29
 * @Description
 **/
@RestController
@Api(value = "双随机抽查", tags = "项目信息")
public class CheckPersonController {

    @Autowired
    private MappingApiService mappingApiService;


    /**
     * @Description: 查询所有抽查人员信息
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/selectAllCheckPerson")
    @ApiOperation(value = "查询所有抽查人员信息",
            notes = "查询所有抽查人员信息")
    public ResultData selectAllCheckPerson(){
        return mappingApiService.selectAllCheckPerson();
    }
    /**
     * @Description: 新增抽查人员
     * @Param: [checkPerson]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/addCheckPerson")
    @ApiOperation(value = "新增抽查人员",
            notes = "通过实体类参数来新增抽查人员")
    public ResultData addCheckPerson(@RequestBody CheckPerson checkPerson){
       return mappingApiService.addCheckPerson(checkPerson);
    }
    /**
     * @Description: 根据抽查比例获取查询人信息
     * @Param: [put]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/selectPartCheckPerson")
    @ApiOperation(value = "根据抽查比例获取查询人信息",
            notes = "通过传入抽查比例来获取查询人信息")
    public ResultData selectPartCheckPerson(@RequestParam("put") Double put){
        return mappingApiService.selectPartCheckPerson(put);
    }

    /**
     * @Description: 分页查询所有审核人员信息
     * @Param: [checkPerson, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/selectCheckPersonByPage")
    @ApiOperation(value = "分页查询所有审核人员信息",
            notes = "通过发送pageNo，pageSize参数来分页查询所有审核人员信息")
    public ResultData selectCheckPersonByPage(@RequestBody CheckPerson checkPerson,
                                              @RequestParam("pageNo") Integer pageNo,
                                              @RequestParam("pageSize") Integer pageSize
    ){
        return mappingApiService.selectCheckPersonByPage(checkPerson, pageNo, pageSize);
    }

    /**
     * @Description: 分页随机抽查审核人员信息
     * @Param: [put, checkPerson, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/selectPartCheckPersonByPage")
    @ApiOperation(value = "分页随机抽查审核人员信息",
            notes = "通过发送pageNo，pageSize，抽查比例参数来分页查询所有审核人员信息")
    public ResultData selectPartCheckPersonByPage(@RequestBody CheckPerson checkPerson,
                                                  @RequestParam("put") Double put,
                                                  @RequestParam("pageNo") Integer pageNo,
                                                  @RequestParam("pageSize") Integer pageSize
    ){
        return mappingApiService.selectPartCheckPersonByPage(checkPerson, put, pageNo, pageSize);
    }

}
