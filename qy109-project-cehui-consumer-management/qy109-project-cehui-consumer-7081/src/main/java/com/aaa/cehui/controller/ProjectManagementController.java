package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.ProjectInfo;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
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
    public ResultData selectProjectByPage(ProjectInfo projectInfo,
                                          @RequestParam("pageNo") Integer pageNo,
                                          @RequestParam("pageSize") Integer pageSize){
        return mappingApiService.selectProjectByPage(projectInfo, pageNo, pageSize);
    }



}
