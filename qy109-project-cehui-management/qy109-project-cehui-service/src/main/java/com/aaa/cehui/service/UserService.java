package com.aaa.cehui.service;


import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.mapper.UserMapper;
import com.aaa.cehui.model.User;

import com.aaa.cehui.utils.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Handler;

import static com.aaa.cehui.utils.DateUtils.DATE_TYPE;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/8 11:47
 * @Description
 **/
@Service
public class UserService extends BaseService<User> {
    @Autowired
    UserMapper userMapper;

    public ResultData selectAllRoles() {

        return null;
    }


    /**
     * @author Seven Lee
     * @description
     * 这个方法用来添加用户的 参数user是前端传来的
     *
     * @param
     * @date 2020/5/22
     * @return java.lang.Boolean
     * @throws
     **/
    public Boolean addUser(User user){
        try {

            //获取当前时间
            Date date = new Date();
            //设置日期格式
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(date);
            //获取一个token值
            String token = IDUtils.getUUID();
            //获取前段传递的参数 放入user中
            //将username传入
            user.setUsername(user.getUsername())
                    .setToken(token)
                    //将password传入
                    .setPassword(user.getPassword())
                    //将Email传入
                    .setEmail(user.getEmail())
                    //将手机号传入
                    .setMobile(user.getMobile())
                    //将角色传入
                    .setType(user.getType())
                    //将部门传入
                    .setDeptId(user.getDeptId())
                    //将状态传入
                    .setStatus(user.getStatus())
                    //将性别传入
                    .setSsex(user.getSsex())
                    //将创建时间传入
                    .setCreateTime(format)
                    //传入id
                    .setId(user.getId());
            int insert = userMapper.insert(user);
            if (insert>0){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
    * @Author LTL
    * @Description 通过主键删除用户
    * @Param [user]
    * @Return java.lang.Integer
    * @DateTime 2020/7/16  9:08
    * @Throws
    */
    public Integer deleteUser(User user){
        //判断前段是否传值成功
        if (!"".equals(user) && null !=user){
            try {
                //执行删除操作
                Integer delete = delete(user);
                if (delete>0){
                    return delete;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
    * @Author LTL
    * @Description 根据id批量删除用户
    * @Param [ids]
    * @Return java.lang.Integer
    * @DateTime 2020/7/16  9:08
    * @Throws
    */
    public Integer deleteMoreUser(List<Integer> ids){
        //判断前段是否传值成功
        if (!"".equals(ids) && null !=ids){
            try {
                //调用父类的批量删除方法
                Integer integer = super.deleteByIds(ids);
                //判断是否查询出结果
                if (integer>0){
                    return integer;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
    * @Author LTL
    * @Description 根据id修改用户信息
    * @Param [user]
    * @Return java.lang.Integer
    * @DateTime 2020/7/16  9:17
    * @Throws
    */
    public Integer updateUser(User user){
        if (!"".equals(user) && null !=user){
            //获取当前时间作为修改时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TYPE);
            String format = simpleDateFormat.format(new Date());
            //把时间存到实体中
            user.setModifyTime(format);
            try {
                //通过父类方法修改用户信息
                Integer update = super.update(user);
                //判断受影响的行数
                if (update>0){
                    return update;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * @Author LTL
     * @Description 分页查询所有用户信息
     * @Param [pageNo, pageSize]
     * @Return com.github.pagehelper.PageInfo
     * @DateTime 2020/7/16  9:07
     * @Throws
     */
    public PageInfo selectAllUser(Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<User> users = userMapper.selectAll();
        if (users.size()>0){
            PageInfo<User> pageInfo = new PageInfo<>(users);
            return pageInfo;
        }else{
            return null;
        }
    }

    public List<User> selectUserById(User user){

      return userMapper.select(user);

    }

}
