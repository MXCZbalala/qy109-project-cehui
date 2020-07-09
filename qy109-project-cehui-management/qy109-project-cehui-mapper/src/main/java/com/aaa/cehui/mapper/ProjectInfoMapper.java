package com.aaa.cehui.mapper;

import com.aaa.cehui.model.ProjectInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProjectInfoMapper extends Mapper<ProjectInfo> {
    /**
       * @Author 吴超
       * @Description 根据项目类型进行查询
       * @Date 17:28 2020/5/31
       * @Param
       * @return java.util.List<com.aaa.wc.model.ProjectInfo>
     */
    List<ProjectInfo> getInfoByType(String projectType);
}