package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.ProjectInfo;
import com.aaa.cehui.service.ProjectManagementService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: qy109-project-cehui
 * @description:    测绘管理-->  项目管理
 * @author: Mr.Wang
 * @create: 2020-07-17 09:48
 **/
@RestController
public class ProjectManagementController extends CommonController<ProjectInfo> {
    @Autowired
    private ProjectManagementService projectService;
    @Override
    public BaseService<ProjectInfo> getBaseService() {
        return projectService;
    }
    /**
    * @Description: 查询所有项目的信息
    * @Param: []
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/17
    */
    @PostMapping("/selectAllInfo")
    public ResultData selectAllInfo(){
        if (projectService.selectAllInfo().size()>0){
            return getSuccess(projectService.selectAllInfo());
        }
        return getFiled();
    }
    /**
    * @Description: 通过主键ID查询项目
    * @Param: [id]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/17
    */
    @PostMapping("/selectById")
    public ResultData selectById(Long id){
        if (projectService.selectById(id)!=null){
            return getSuccess(projectService.selectById(id));
        }
        return getFiled();
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
        if (projectService.addProjectInfo(projectInfo)>0){
            return addSuccess(projectService.addProjectInfo(projectInfo));
        }
        return addFiled();
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
        Integer integer = projectService.updateProjectInfoById(projectInfo);
        if (integer>0){
            return updateSuccess(integer);
        }
        return updateFiled();
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
        List<ProjectInfo> infoType = projectService.getInfoType(projectType);
        if (infoType.size()>0){
            return getSuccess(infoType);
        }
        return getFiled();
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
        PageInfo<ProjectInfo> pageInfo = projectService.selectListByPage(projectInfo, pageNo, pageSize);
        if (null!=pageInfo && !"".equals(pageInfo)){
            return getSuccess(pageInfo);
        }
        return getFiled();
    }
}
