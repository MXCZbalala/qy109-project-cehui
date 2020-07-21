package com.aaa.cehui.mapper;

import com.aaa.cehui.model.Resource;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResourceMapper extends Mapper<Resource> {
    List<Resource> selectAllResourceByUnitId(Long id);
}