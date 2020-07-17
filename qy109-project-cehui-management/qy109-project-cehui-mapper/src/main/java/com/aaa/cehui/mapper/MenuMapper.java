package com.aaa.cehui.mapper;/**
 * @Auther: 吴超
 * @Date: 2020/5/29 10:08
 * @Description:
 */

import com.aaa.cehui.model.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigInteger;
import java.util.List;

/**
* @Author LTL
* @Description
* @Param
* @Return
* @DateTime 2020/7/17  19:45
* @Throws
*/
public interface MenuMapper extends Mapper<Menu> {
    /*@Select(value = "select MENU_NAME from t_menu c join t_role_menu d on" +
            " c.MENU_ID = d.MENU_ID where ROLE_ID in" +
            " (select ROLE_ID from t_user_role a join t_user b on a.USER_ID = b.id and b.id=#{id}) and c.PARENT_ID =#{PARENT_ID}")
    List<String> selectMenu(@Param("id") BigInteger id, @Param("PARENT_ID") BigInteger PARENT_ID);*/
}
