package com.aaa.cehui.mapper;

import com.aaa.cehui.model.ProjectInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProjectInfoMapper extends Mapper<ProjectInfo> {
    /**
    * @Author LTL
    * @Description 根据项目类型进行查询
    * @Param [projectType]
    * @Return java.util.List<com.aaa.cehui.model.ProjectInfo>
    * @DateTime 2020/7/16  8:40
    * @Throws
    */
    List<ProjectInfo> getInfoByType(String projectType);
}