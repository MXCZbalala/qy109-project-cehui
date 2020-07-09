package com.aaa.cehui.mapper;/**
 * @Auther: 吴超
 * @Date: 2020/5/29 10:08
 * @Description:
 */

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * @Auther: 吴超
 * @Date: 2020/5/29 10:08
 * @Description:
 */
@Mapper
@Repository
public interface MenuMapper   {
    @Select(value = "select MENU_NAME from t_menu c join t_role_menu d on" +
            " c.MENU_ID = d.MENU_ID where ROLE_ID in" +
            " (select ROLE_ID from t_user_role a join t_user b on a.USER_ID = b.id and b.id=#{id}) and c.PARENT_ID =#{PARENT_ID}")
    List<String> selectMenu(@Param("id") BigInteger id, @Param("PARENT_ID") BigInteger PARENT_ID);
}
