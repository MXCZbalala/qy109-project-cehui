package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.mapper.PrincipalMapper;
import com.aaa.cehui.model.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ltl
 * @Date 2020/7/16  20:25
 * @Description
 *     测绘管理--单位基本信息--负责人基本信息
 **/
@Service
public class PrincipalService extends BaseService<Principal> {

    @Autowired
    PrincipalMapper principalMapper;



}
