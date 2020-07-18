package com.aaa.cehui.mapper;

import com.aaa.cehui.model.SpecialPost;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpecialPostMapper extends Mapper<SpecialPost> {
    /**
     * 根据UserId查询特殊岗位人员信息
     * @param userId
     * @return
     */
    List<SpecialPost> selectSpecialPost(Long userId);

}