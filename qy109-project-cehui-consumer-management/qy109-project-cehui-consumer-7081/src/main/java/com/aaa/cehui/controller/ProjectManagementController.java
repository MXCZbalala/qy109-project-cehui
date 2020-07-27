package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.ProjectInfo;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/27  18:41
 * @Description
 **/
@RestController
@Api(value = "项目管理信息", tags = "项目管理接口")
public class ProjectManagementController {

    @Autowired
    private MappingApiService mappingApiService;

    /**
     * @Description: 查询所有项目的信息
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/selectAllInfo")
    @ApiOperation(value = "查询所有项目的信息",
            notes = "查询所有项目信息")
    public ResultData selectAllInfo(){
        return mappingApiService.selectAllInfo();
    }

    /**
     * @Description: 通过主键ID查询项目
     * @Param: [id]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/selectProjectInfoById")
    @ApiOperation(value = "通过主键ID查询项目",
            notes = "通过发送主键id来查询项目信息")
    public ResultData selectProjectInfoById(Long id){
        return mappingApiService.selectProjectInfoById(id);
    }

    /**
     * @Description: 新增项目
     * @Param: [projectInfo]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/addProjectInfo")
    @ApiOperation(value = "新增项目信息",
            notes = "通过发送实体类参数来新增项目信息")
    public ResultData addProjectInfo(ProjectInfo projectInfo){
        return mappingApiService.addProjectInfo(projectInfo);
    }

    /**
     * @Description: 通过ID修改项目
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/updateProjectInfoById")
    @ApiOperation(value = "通过ID修改项目",
            notes = "通过发送id参数来修改项目信息")
    public ResultData updateProjectInfoById(ProjectInfo projectInfo){
        return mappingApiService.updateProjectInfoById(projectInfo);
    }

    /**
     * @Description: 通过项目类型查询项目
     * @Param: [projectType]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/getInfoType")
    @ApiOperation(value = "通过项目类型查询项目",
            notes = "通过发送项目类型参数来查询项目信息")
    public ResultData getInfoType(String projectType){
        return mappingApiService.getInfoType(projectType);
    }

    /**
     * @Description: 项目管理的分页查询
     * @Param: [projectInfo, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/selectProjectByPage")
    @ApiOperation(value = "项目管理的分页查询",
            notes = "通过发送pageNo，pageSize参数来分页查询所有项目信息")
    public ResultData selectProjectByPage(ProjectInfo projectInfo,
                                          @RequestParam("pageNo") Integer pageNo,
                                          @RequestParam("pageSize") Integer pageSize){
        return mappingApiService.selectProjectByPage(projectInfo, pageNo, pageSize);
    }



}
