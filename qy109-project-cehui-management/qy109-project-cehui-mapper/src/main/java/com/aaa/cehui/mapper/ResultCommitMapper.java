package com.aaa.cehui.mapper;

import com.aaa.cehui.model.ResultCommit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResultCommitMapper extends Mapper<ResultCommit> {

    /**
    * @Author LTL
    * @Description 测绘成果的模糊成勋
    * @Param [name, projectType, resultDate]
    * @Return java.util.List<com.aaa.cehui.model.ResultCommit>
    * @DateTime 2020/7/16  8:39
    * @Throws
    */
    List<ResultCommit> fuzzyResultName(@Param("name") String name,
                                       @Param("projectType") String projectType,
                                       @Param("resultDate") String resultDate);

    /**
    * @Author LTL
    * @Description 测绘成果详情
    * @Param [id]
    * @Return com.aaa.cehui.model.ResultCommit
    * @DateTime 2020/7/16  8:40
    * @Throws
    */
    ResultCommit selectResultDetails(@Param("id") Long id);
}