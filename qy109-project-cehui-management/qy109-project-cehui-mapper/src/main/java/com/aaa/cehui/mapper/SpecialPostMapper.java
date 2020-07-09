package com.aaa.cehui.mapper;

import com.aaa.cehui.model.SpecialPost;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpecialPostMapper extends Mapper<SpecialPost> {

    List<SpecialPost> selectSpecialPost(Long userId);

}