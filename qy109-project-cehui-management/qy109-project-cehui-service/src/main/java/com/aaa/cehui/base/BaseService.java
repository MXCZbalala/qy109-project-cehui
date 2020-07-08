package com.aaa.cehui.base;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/8 11:42
 * @Description
 *      通用service
 *
 **/
public abstract class BaseService<T> {

    @Autowired
    private Mapper<T> mapper;

    protected Mapper getMapper() {
        return mapper;
    }

    public ResultData insertDta(T t) {
        int insert = mapper.insert(t);
        if(insert > 0){
            return new ResultData().setCode("300").setMsg("数据插入成功");
        }
        return null;
    }

}
