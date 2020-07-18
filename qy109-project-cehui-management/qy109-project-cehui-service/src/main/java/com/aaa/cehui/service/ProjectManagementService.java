package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.ProjectInfoMapper;
import com.aaa.cehui.model.ProjectInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: qy109-project-cehui
 * @description:      测绘管理-->  项目管理
 * @author: Mr.Wang
 * @create: 2020-07-16 15:42
 **/
@Service
public class ProjectManagementService  extends BaseService<ProjectInfo> {
    @Autowired
    private ProjectInfoMapper projectInfoMapper;
    
    /**
    * @Description: 查询所有项目的信息
    * @Param: []
    * @return: java.util.List<com.aaa.cehui.model.ProjectInfo>
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    public List<ProjectInfo> selectAllInfo(){
        List<ProjectInfo> lists = projectInfoMapper.selectAll();
        if (lists.size()>0){
            return lists;
        }
        return null;
    }
    /**
    * @Description: 通过主键ID查询项目
    * @Param: [id]
    * @return: com.aaa.cehui.model.ProjectInfo
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    public ProjectInfo selectById(Long id){
        if (!"".equals(id)){
            ProjectInfo projectInfo= projectInfoMapper.selectByPrimaryKey(id);
            if (!"".equals(projectInfo)){
                return projectInfo;
            }
            return null;
        }
        return null;
    }
    /**
    * @Description: 新增项目
    * @Param: [projectInfo]
    * @return: java.lang.Integer
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    public Integer addProjectInfo(ProjectInfo projectInfo){
        Random random = new Random();
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 19; i++) {
            string.append(random.nextInt(10));
        }
        Long id =Long.parseLong(String.valueOf(string));
        projectInfo.setId(id);
        int insert = projectInfoMapper.insert(projectInfo);
        if (insert>0){
            return insert;
        }
        return null;
    }
    /**
    * @Description: 通过ID修改项目
    * @Param: [projectInfo]
    * @return: java.lang.Integer
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    public Integer updateProjectInfoById(ProjectInfo projectInfo){
        if (null!=projectInfo){
            Integer i =super.update(projectInfo);
            if (i>0){
                return i;
            }
        }
        return null;
    }
    /**
    * @Description: 通过项目类型查询项目
    * @Param: [projectType]
    * @return: java.util.List<com.aaa.cehui.model.ProjectInfo>
    * @Author: Mr.Wang
    * @Date: 2020/7/17
    */
    public List<ProjectInfo> getInfoType(String projectType){
        if (null!=projectType){
            List<ProjectInfo> infoByType = projectInfoMapper.getInfoByType(projectType);
            if (infoByType.size()>0){
                return infoByType;
            }
        }
        return null;
    }
    /**
    * @Description: 项目管理的分页查询
    * @Param: [projectInfo, pageNo, pageSize]
    * @return: com.github.pagehelper.PageInfo<com.aaa.cehui.model.ProjectInfo>
    * @Author: Mr.Wang
    * @Date: 2020/7/17
    */
    public PageInfo<ProjectInfo> selectProjectByPage(ProjectInfo projectInfo,Integer pageNo,Integer pageSize){
        PageInfo<ProjectInfo> pageInfo = selectListByPage(projectInfo,pageNo,pageSize);
        if (null!=pageInfo && !"".equals(pageInfo)){
            return pageInfo;
        }
        return null;
    }
}
