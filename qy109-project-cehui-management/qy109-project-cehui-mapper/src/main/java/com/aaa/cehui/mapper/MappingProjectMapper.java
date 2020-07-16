package com.aaa.cehui.mapper;

import com.aaa.cehui.model.MappingProject;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author ligen
 * @description
 *  项目汇交
 * @Data Create in 2020/5/22 9:52
 */
public interface MappingProjectMapper extends Mapper<MappingProject> {

    /**
    * @Author LTL
    * @Description 查询所有已提交的项目信息
    * @Param []
    * @Return java.util.List<com.aaa.cehui.model.MappingProject>
    * @DateTime 2020/7/16  8:39
    * @Throws
    */
    List<MappingProject> selectAllMappingProject();

    /**
    * @Author LTL
    * @Description 条件查询 根据项目类型projectType 查询所有已提交项
    * @Param [projectType]
    * @Return java.util.List<com.aaa.cehui.model.MappingProject>
    * @DateTime 2020/7/16  8:39
    * @Throws
    */
    List<MappingProject> selectAllByProjectType(String projectType);
    /**
    * @Author LTL
    * @Description 模糊查询(动态sql 查询测绘项目名称)
    * @Param [projectName, projectType, startDate]
    * @Return java.util.List<com.aaa.cehui.model.MappingProject>
    * @DateTime 2020/7/16  8:39
    * @Throws
    */
    List<MappingProject> fuzzyProjectName(@Param("projectName") String projectName,
                                          @Param("projectType") String projectType,
                                          @Param("startDate") String startDate);
}