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
       * @Author 吴超
       * @Description 查询所有已提交的项目信息
       * @Date 16:07 2020/5/29
       * @Param * @param
       * @return java.util.List<com.aaa.wc.model.MappingProject>
     */
    List<MappingProject> selectAllMappingProject();

    /**
       * @Author 吴超
       * @Description 条件查询 根据项目类型projectType 查询所有已提交项
       * @Date 16:07 2020/5/29
       * @Param * @param projectType
       * @return java.util.List<com.aaa.wc.model.MappingProject>
     */
    List<MappingProject> selectAllByProjectType(String projectType);
    /**
       * @Author 吴超
       * @Description 模糊查询(动态sql 查询测绘项目名称)
       * @Date 16:08 2020/5/29
       * @Param * @param projectName
        * @param projectType
        * @param startDate
       * @return java.util.List<com.aaa.wc.model.MappingProject>
     */
    List<MappingProject> fuzzyProjectName(@Param("projectName") String projectName,
                                          @Param("projectType") String projectType,
                                          @Param("startDate") String startDate);
}