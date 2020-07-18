package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.ProjectInfo;
import com.aaa.cehui.service.ProjectAuditService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: qy109-project-cehui
 * @description:       测绘管理-->项目审核
 * @author: Mr.Wang
 * @create: 2020-07-18 09:52
 **/
@RestController
public class ProjectAuditController extends CommonController<ProjectInfo> {
    @Autowired
    private ProjectAuditService projectAuditService;
    @Override
    public BaseService<ProjectInfo> getBaseService() {
        return projectAuditService;
    }
    /**
    * @Description: 项目信息的查询
    * @Param: []
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/18
    */
    @PostMapping("/selectAllProject")
    public ResultData selectAllProject(){
        List<ProjectInfo> infoList = projectAuditService.selectAllProject();
        if (null!=infoList&&infoList.size()>0){
            return getSuccess(infoList);
        }
        return getFiled();
    }
    /**
    * @Description: 项目信息的分页查询
    * @Param: [projectInfo, pageNo, pageSize]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/18
    */
    @PostMapping("/selectAllProjectByPage")
    public ResultData selectAllProjectByPage(ProjectInfo projectInfo, @RequestParam("pageNo") Integer pageNo,
                                             @RequestParam("pageSize") Integer pageSize){
        PageInfo<ProjectInfo> pageInfo = projectAuditService.selectAllProjectByPage(projectInfo, pageNo, pageSize);
        if (null!=pageInfo&&!"".equals(pageInfo)){
            return getSuccess(pageInfo);
        }
        return getFiled();
    }
    /**
    * @Description: 项目信息通过项目名称模糊查询
    * @Param: [projectName]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/18
    */
    @PostMapping("/getLikeProjectIno")
    public ResultData getLikeProjectIno(@RequestParam("projectName") String projectName){
        List<ProjectInfo> likeProjectIno = projectAuditService.getLikeProjectIno(projectName);
        if (likeProjectIno.size()>0 && projectAuditService !=null){
            return getSuccess(likeProjectIno);
        }
        return null;
    }
}
