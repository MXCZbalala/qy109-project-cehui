package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.MappingProject;
import com.aaa.cehui.service.MappingProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheAnnotationParser;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @program: qy109-project-cehui
 * @description:        测绘管理-->项目汇交
 * @author: Mr.Wang
 * @create: 2020-07-17 15:24
 **/
@RestController
public class MappingProjectController extends CommonController<MappingProject> {
    @Autowired
    private MappingProjectService mappingProjectService;
    @Override
    public BaseService<MappingProject> getBaseService() {
        return mappingProjectService;
    }
    /**
    * @Description: 查询所有已经提交的项目
    * @Param: []
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/17
    */
    @PostMapping("/selectAllMappingProject")
    public ResultData selectAllMappingProject(){
        List<MappingProject> lists = mappingProjectService.selectAllMappingProject();
        if (lists.size()>0 && lists!=null){
            return getSuccess(lists);
        }
        return getFiled();
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
        List<MappingProject> list = mappingProjectService.selectMappingProjectByType(projectType);
        if (list.size()>0 && null != list){
            return getSuccess(list);
        }
        return getFiled();
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
                                                       @RequestParam("pageSize") Integer pageSize){
        PageInfo<MappingProject> projectType1 = mappingProjectService.selectListByPageAndFiled(pageNo, pageSize, Sqls.custom().andEqualTo("projectType", projectType), null);
        if (null!=projectType && !"".equals(projectType1)){
            return getSuccess(projectType1);
        }
        return getFiled();
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
                                                 @RequestParam("pageSize") Integer pageSize){
        PageInfo<MappingProject> pageInfo = mappingProjectService.selectMappingProjectByPage(mappingProject, pageNo, pageSize);
        if (null!=pageInfo && !"".equals(pageInfo)){
            return getSuccess(pageInfo);
        }
        return getFiled();
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
        Integer integer = mappingProjectService.updateMappingProject(mappingProject);
        if (integer>0 && integer !=null){
            return updateSuccess(integer);
        }
        return updateFiled();
    }

}
