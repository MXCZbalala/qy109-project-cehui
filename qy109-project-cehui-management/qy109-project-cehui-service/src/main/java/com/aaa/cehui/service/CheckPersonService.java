package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.CheckPersonMapper;
import com.aaa.cehui.model.CheckPerson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @program: qy109-project-cehui
 * @description:        测绘管理-->双随机抽查-->抽查人员
 * @author: Mr.Wang
 * @create: 2020-07-20 20:23
 **/
@Service
public class CheckPersonService extends BaseService<CheckPerson> {
    @Autowired
    private CheckPersonMapper checkPersonMapper;
    /**
    * @Description: 根据抽查比例获取查询人信息
    * @Param: []
    * @return: java.util.List<com.aaa.cehui.model.CheckPerson>
    * @Author: Mr.Wang
    * @Date: 2020/7/20
    */
    public List<CheckPerson> selectPartCheckPerson(Double put){
        List<CheckPerson> checkPeople = checkPersonMapper.selectAll();
        double a = (double)(checkPeople.size());
        int v = (int)(a * (put/100));
        List<CheckPerson> lists = new ArrayList<CheckPerson>();
        for (int i = 0; i < v; i++) {
            lists.add(checkPeople.get(i));
        }
        if (lists.size()>0 && lists!=null){
            return lists;
        }
        return null;
    }
    /**
    * @Description: 分页通过抽查比例查询审核人员信息
    * @Param: [put, checkPerson, pageNo, pageSize]
    * @return: com.github.pagehelper.PageInfo<com.aaa.cehui.model.CheckPerson>
    * @Author: Mr.Wang
    * @Date: 2020/7/21
    */
    public PageInfo<CheckPerson> selectPartCheckPersonByPage(Double put, CheckPerson checkPerson,Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<CheckPerson> select = select(checkPerson);
        int size = select.size();
        double a = (double)(size);
        int v = (int)(a * (put/100));
        List<CheckPerson> lists = new ArrayList<CheckPerson>();
        Collections.shuffle(select);
        for (int i = 0; i < v; i++) {
            lists.add(select.get(i));
        }
        PageInfo<CheckPerson> pageInfo = new PageInfo<CheckPerson>(lists);
        if (lists.size()>0 && lists != null){
            return pageInfo;
        }
        return null;
    }

}
