package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.MappingProject;
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
 * @Date 2020/7/27  11:33
 * @Description
 **/
@RestController
@Api(value = "项目管理", tags = "项目信息")
public class MappingProjectController {
    @Autowired
    private MappingApiService mappingApiService;

    /**
     * @Description: 查询所有已经提交的项目
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/selectAllMappingProject")
    @ApiOperation(value = "查询项目信息",
            notes = "查询所有的项目信息")
    public ResultData selectAllMappingProject(){
        return mappingApiService.selectAllMappingProject();
    }

    /**
     * @Description: 通过项目类型查询项目
     * @Param: [projectType]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/selectMappingProjectByType")
    @ApiOperation(value = "通过项目类型查询项目信息",
            notes = "通过发送项目类型来查询项目信息")
    public ResultData selectMappingProjectByType(@RequestParam("projectType") String projectType){
        return mappingApiService.selectMappingProjectByType(projectType);
    }

    /**
     * @Description: 分页通过项目类型查询项目
     * @Param: [projectType, pageNo, pageSize, where]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/selectMappingProjectByTypeByPage")
    @ApiOperation(value = "分页通过项目类型查询项目信息",
            notes = "通过发送项目类型，pageNo，pageSize来分页查询项目信息")
    public ResultData selectMappingProjectByTypeByPage(@RequestParam("projectType") String projectType,
                                                       @RequestParam("pageNo") Integer pageNo,
                                                       @RequestParam("pageSize") Integer pageSize
    ){
        return mappingApiService.selectMappingProjectByTypeByPage(projectType, pageNo, pageSize);
    }

    /**
     * @Description: 分页查询，根据所提交的项目进行分页
     * @Param: [mappingProject, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/selectMappingProjectByPage")
    @ApiOperation(value = "分页通查询项目信息",
            notes = "通过发送pageNo，pageSize来分页查询所有项目信息")
    public ResultData selectMappingProjectByPage(@RequestBody MappingProject mappingProject,
                                                 @RequestParam("pageNo") Integer pageNo,
                                                 @RequestParam("pageSize") Integer pageSize)
    {
        return mappingApiService.selectMappingProjectByPage(mappingProject, pageNo, pageSize);
    }

    /**
     * @Description: 通过ID修改汇交项目
     * @Param: [mappingProject]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/updateMappingProject")
    @ApiOperation(value = "修改汇交项目",
            notes = "通过发送实体类参数来修改汇交项目信息")
    public ResultData updateMappingProject(@RequestBody MappingProject mappingProject){
        return mappingApiService.updateMappingProject(mappingProject);
    }
}
