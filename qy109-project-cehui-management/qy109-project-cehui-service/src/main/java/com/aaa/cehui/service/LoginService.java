package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.model.User;
import com.aaa.cehui.vo.TokenVo;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/15 9:33
 * @Description
 **/
@Service
public class LoginService extends BaseService<User> {


    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     *
     *      pojo：实体类
     *      povo:封装类型(当在实际开发中，会有很多种情况导致多表联查的时候无法装载数据--->我就根据返回前端的数据自己
     *      去封装一个对象出来---->view object)
     * @param [user]
     * @date 2020/7/15
     * @return com.aaa.lee.base.ResultData
     * @throws
    **/
    public TokenVo doLogin(User user) {
        TokenVo tokenVo = new TokenVo();
        User user1 = new User();
        // 1.判断User是否为null
        if(null != user) {
            user1.setUsername(user.getUsername());
            User user2 = super.selectOne(user1);
            // 2.判断user2是否为null
            if(null == user2) {
                tokenVo.setIfSuccess(false).setType(1);
                return tokenVo;
            } else {
                // 用户名OK，查询密码
                user1.setPassword(user.getPassword());
                User user3 = super.selectOne(user1);
                // 3.判断user3是否为null
                if(null == user3) {
                    tokenVo.setIfSuccess(false).setType(2);
                    return tokenVo;
                } else {
                    // 登录成功
                    /**
                     *
                     * !!!!!!mybatis是无法检测连接符的，他会把连接符进行转译(\\-)
                     * 需要把连接符替换掉
                     *
                     *
                     */
                    String token = UUID.randomUUID().toString().replaceAll("-","");
                    user3.setToken(token);
                    Integer updateResult = super.update(user3);
                    if(updateResult > 0) {
                        tokenVo.setIfSuccess(true).setToken(token);
                    } else {
                        tokenVo.setIfSuccess(false).setType(4);
                        return tokenVo;
                    }
                }
            }
        } else {
            tokenVo.setIfSuccess(false).setType(4);
            return tokenVo;
        }
        return tokenVo;
    }

}
