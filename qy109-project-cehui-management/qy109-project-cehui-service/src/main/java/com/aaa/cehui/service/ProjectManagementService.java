package com.aaa.cehui.service;

import com.aaa.cehui.mapper.ProjectInfoMapper;
import com.aaa.cehui.model.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.spi.NamingManager;
import java.util.List;

/**
 * @program: qy109-project-cehui
 * @description:        项目管理
 * @author: Mr.Wang
 * @create: 2020-07-16 15:42
 **/
@Service
public class ProjectManagementService {
    @Autowired
    private ProjectInfoMapper projectInfoMapper;
    
    /**
    * @Description: 查询所有项目的信息
    * @Param: []
    * @return: java.util.List<com.aaa.cehui.model.ProjectInfo>
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    public List<ProjectInfo> selectAll(){
        List<ProjectInfo> lists = projectInfoMapper.selectAll();
        if (lists.size()>0){
            return lists;
        }
        return null;
    }
    /**
    * @Description: 通过主键ID查询项目信息
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
    * @Description: 新增项目信息
    * @Param: [projectInfo]
    * @return: java.lang.Integer
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    public Integer addProjectInfo(ProjectInfo projectInfo){
        if (null!=projectInfo){
            Integer i = projectInfoMapper.insert(projectInfo);
            if (i>0){
                return i;
            }
        }
        return null;
    }

}
