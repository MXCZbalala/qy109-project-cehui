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
 * @Date 2020/7/27  17:01
 * @Description
 **/
@RestController
@Api(value = "项目审核信息", tags = "项目管理接口")
public class ProjectAuditController {

    @Autowired
    private MappingApiService mappingApiService;

    /**
     * @Description: 项目信息的查询
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/18
     */
    @PostMapping("/selectAllProject")
    @ApiOperation(value = "项目信息的查询",
            notes = "查询所有的项目信息")
    public ResultData selectAllProject(){
        return mappingApiService.selectAllProject();
    }


    /**
     * @Description: 项目信息的分页查询
     * @Param: [projectInfo, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/18
     */
    @PostMapping("/selectAllProjectByPage")
    @ApiOperation(value = "项目信息的分页查询",
            notes = "通过发送pageNo，pageSize来分页查询所有项目信息")
    public ResultData selectAllProjectByPage(ProjectInfo projectInfo,
                                             @RequestParam("pageNo") Integer pageNo,
                                             @RequestParam("pageSize") Integer pageSize
    ){
        return mappingApiService.selectAllProjectByPage(projectInfo, pageNo, pageSize);
    }

    /**
     * @Description: 项目信息通过项目名称模糊查询
     * @Param: [projectName]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/18
     */
    @PostMapping("/getLikeProjectIno")
    @ApiOperation(value = "通过项目名称模糊查询",
            notes = "通过发送项目名称，模糊查询所有项目信息")
    public ResultData getLikeProjectIno(@RequestParam("projectName") String projectName){
        return mappingApiService.getLikeProjectIno(projectName);
    }

    /**
     * @Description: 分页项目信息通过项目名称模糊查询
     * @Param: [projectName, pageNo, pageSize, where]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/getLikeProjectInoByPage")
    @ApiOperation(value = "分页项目信息通过项目名称模糊查询",
            notes = "通过发送项目名称，pageNo,pageSize模糊分页查询所有项目信息")
    public ResultData getLikeProjectInoByPage(@RequestParam("projectName") String projectName,
                                              @RequestParam("pageNo") Integer pageNo,
                                              @RequestParam("pageSize") Integer pageSize
    ){
        return mappingApiService.getLikeProjectInoByPage(projectName, pageNo, pageSize);
    }


}
