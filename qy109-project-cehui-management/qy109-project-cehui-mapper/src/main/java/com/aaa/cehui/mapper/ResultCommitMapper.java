package com.aaa.cehui.mapper;

import com.aaa.cehui.model.ResultCommit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResultCommitMapper extends Mapper<ResultCommit> {

    List<ResultCommit> fuzzyResultName(@Param("name") String name,
                                       @Param("projectType") String projectType,
                                       @Param("resultDate") String resultDate);

    ResultCommit selectResultDetails(@Param("id") Long id);
}