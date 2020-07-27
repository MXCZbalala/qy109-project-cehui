package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.MappingProject;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
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
    public ResultData updateMappingProject(@RequestBody MappingProject mappingProject){
        return mappingApiService.updateMappingProject(mappingProject);
    }
}
