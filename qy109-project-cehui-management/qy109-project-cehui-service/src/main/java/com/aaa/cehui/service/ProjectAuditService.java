package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.ProjectInfoMapper;
import com.aaa.cehui.model.Audit;
import com.aaa.cehui.model.ProjectInfo;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: qy109-project-cehui
 * @description:    测绘管理-->项目审核
 * @author: Mr.Wang
 * @create: 2020-07-18 09:16
 **/
@Service
public class ProjectAuditService extends BaseService<ProjectInfo> {
    @Autowired
    private ProjectInfoMapper projectInfoMapper;
    
    /**
    * @Description: 项目信息的查询
    * @Param: []
    * @return: java.util.List<com.aaa.cehui.model.ProjectInfo>
    * @Author: Mr.Wang
    * @Date: 2020/7/18
    */
    public List<ProjectInfo> selectAllProject(){
        List<ProjectInfo> infoList = selectAll();
        if (null!=infoList && infoList.size()>0){
            return infoList;
        }
        return null;
    }
    /**
    * @Description: 项目信息的分页查询
    * @Param: []
    * @return: com.github.pagehelper.PageInfo<com.aaa.cehui.model.ProjectInfo>
    * @Author: Mr.Wang
    * @Date: 2020/7/18
    */
    public PageInfo<ProjectInfo> selectAllProjectByPage(ProjectInfo projectInfo,Integer pageNo,Integer pageSize){
        PageInfo<ProjectInfo> pageInfo = selectListByPage(projectInfo, pageNo, pageSize);
        if (null!=pageInfo && !"".equals(pageInfo)){
            return pageInfo;
        }
        return null;
    }
    /**
    * @Description: 项目信息通过项目名称模糊查询
    * @Param: []
    * @return: java.util.List<com.aaa.cehui.model.ProjectInfo>
    * @Author: Mr.Wang
    * @Date: 2020/7/18
    */
    public List<ProjectInfo> getLikeProjectIno(String projectName){
        if (projectName!=null&&!"".equals(projectName)){
            List<ProjectInfo> likeProjectIno = projectInfoMapper.getLikeProjectIno(projectName);
            if (likeProjectIno.size()>0 && null != likeProjectIno){
                return likeProjectIno;
            }
        }
        return null;
    }
}
