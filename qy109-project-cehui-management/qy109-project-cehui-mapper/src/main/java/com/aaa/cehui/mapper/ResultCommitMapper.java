package com.aaa.cehui.mapper;

import com.aaa.cehui.model.ResultCommit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResultCommitMapper extends Mapper<ResultCommit> {

    /**
       * @Author 吴超
       * @Description 测绘成果的模糊成勋
       * @Date 17:46 2020/6/1
       * @Param
       * @return java.util.List<com.aaa.wc.model.ResultCommit>
     */
    List<ResultCommit> fuzzyResultName(@Param("name") String name,
                                       @Param("projectType") String projectType,
                                       @Param("resultDate") String resultDate);

    /**
       * @Author 吴超
       * @Description 测绘成果详情
       * @Date 17:47 2020/6/1
       * @Param
       * @return com.aaa.wc.model.ResultCommit
     */
    ResultCommit selectResultDetails(@Param("id") Long id);
}