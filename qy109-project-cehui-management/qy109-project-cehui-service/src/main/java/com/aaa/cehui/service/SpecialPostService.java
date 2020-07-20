package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.SpecialPostMapper;
import com.aaa.cehui.model.SpecialPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/16  22:17
 * @Description
 **/
@Service
public class SpecialPostService extends BaseService<SpecialPost> {
    @Autowired
    private SpecialPostMapper specialPostMapper;

    /**
     * 通过UserId查询特殊岗位人员
     * @param userId
     * @return
     */
    public List<SpecialPost> queryByUserId(Long userId){
        return specialPostMapper.selectSpecialPost(userId);
    }
}
