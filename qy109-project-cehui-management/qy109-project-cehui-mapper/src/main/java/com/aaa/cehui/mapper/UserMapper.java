package com.aaa.cehui.mapper;

import com.aaa.cehui.model.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface UserMapper extends Mapper<User> {
     HashMap<String,Object> selectId(@Param("username") String username);

     List<User> selectAllUser();

     List<User> selectUserByDeptNo(Integer deptno);

     User selectUserById(Integer id);
}