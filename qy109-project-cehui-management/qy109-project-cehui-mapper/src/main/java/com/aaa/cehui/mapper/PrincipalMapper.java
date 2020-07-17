package com.aaa.cehui.mapper;

import com.aaa.cehui.model.Principal;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PrincipalMapper extends Mapper<Principal> {


    int updateList(Principal principal);

}