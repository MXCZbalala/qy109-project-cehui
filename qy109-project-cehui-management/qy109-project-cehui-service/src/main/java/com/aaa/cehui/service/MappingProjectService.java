package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.MappingProjectMapper;
import com.aaa.cehui.model.MappingProject;
import com.aaa.cehui.model.Resource;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @program: qy109-project-cehui
 * @description:        测绘管理-->项目汇交
 * @author: Mr.Wang
 * @create: 2020-07-17 11:14
 **/
@Service
public class MappingProjectService extends BaseService<MappingProject> {
    @Autowired
    private MappingProjectMapper mappingProjectMapper;

    /**
    * @Description: 查询所有已经提交的项目
    * @Param: []
    * @return: java.util.List<com.aaa.cehui.model.MappingProject>
    * @Author: Mr.Wang
    * @Date: 2020/7/17
    */
    public List<MappingProject> selectAllMappingProject(){
        List<MappingProject> lists=mappingProjectMapper.selectAllMappingProject();
        if (lists.size()>0 && lists!=null){
            return lists;
        }
        return null;
    }
    /**
    * @Description: 根据项目类型查询项目
    * @Param: [projectType]
    * @return: java.util.List<com.aaa.cehui.model.MappingProject>
    * @Author: Mr.Wang
    * @Date: 2020/7/17
    */
    public List<MappingProject> selectMappingProjectByType(String projectType){
        List<MappingProject> lists = mappingProjectMapper.selectAllByProjectType(projectType);
        if (lists.size()>0 && lists!=null){
            return lists;
        }
        return null;
    }
    /**
    * @Description: 分页查询，根据所提交的项目进行分页
    * @Param: [mappingProject, pageNO, pageSize]
    * @return: com.github.pagehelper.PageInfo<com.aaa.cehui.model.MappingProject>
    * @Author: Mr.Wang
    * @Date: 2020/7/17
    */
    public PageInfo<MappingProject> selectMappingProjectByPage(MappingProject mappingProject,Integer pageNo,Integer pageSize){
        PageInfo<MappingProject> pageInfo = selectListByPage(mappingProject, pageNo, pageSize);
        if (null!=pageInfo && !"".equals(pageInfo)){
            return pageInfo;
        }
        return null;
    }
    /**
    * @Description: 通过ID修改汇交项目
    * @Param: [mappingProject]
    * @return: java.lang.Integer
    * @Author: Mr.Wang
    * @Date: 2020/7/17
    */
    public Integer updateMappingProject(MappingProject mappingProject){
        Integer update = super.update(mappingProject);
        if (null!=update && update>0){
            return update;
        }
        return null;
    }


}
