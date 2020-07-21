package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.CheckPerson;
import com.aaa.cehui.service.CheckPersonService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @program: qy109-project-cehui
 * @description:        测绘管理-->双随机抽查-->抽查人员
 * @author: Mr.Wang
 * @create: 2020-07-20 20:26
 **/
@RestController
public class CheckPersonController extends CommonController<CheckPerson> {
    @Autowired
    private CheckPersonService checkPersonService;
    @Override
    public BaseService<CheckPerson> getBaseService() {
        return checkPersonService;
    }
    /**
    * @Description: 查询所有抽查人员信息
    * @Param: []
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/20
    */
    @PostMapping("/selectAllCheckPerson")
    public ResultData selectAllCheckPerson(){
        List<CheckPerson> checkPeople = checkPersonService.selectAll();
        if (checkPeople.size()>0 && checkPeople!=null){
            return getSuccess(checkPeople);
        }
        return getFiled();
    }
    /**
    * @Description: 新增抽查人员
    * @Param: [checkPerson]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/20
    */
    @PostMapping("/addCheckPerson")
    public ResultData addCheckPerson(CheckPerson checkPerson){
        Integer add = checkPersonService.add(checkPerson);
        if (null!=add && add>0){
            return addSuccess(add);
        }
        return addFiled();
    }
    /**
    * @Description: 根据抽查比例获取查询人信息
    * @Param: [put]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/20
    */
    @PostMapping("/selectPartCheckPerson")
    public ResultData selectPartCheckPerson(Double put){
        List<CheckPerson> checkPeople = checkPersonService.selectPartCheckPerson(put);
        if (checkPeople.size()>0 && checkPeople!=null){
            return getSuccess(checkPeople);
        }
        return getFiled();
    }
    /**
    * @Description: 分页查询所有审核人员信息
    * @Param: [checkPerson, pageNo, pageSize]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/21
    */
    @PostMapping("/selectCheckPersonByPage")
    public ResultData selectCheckPersonByPage(CheckPerson checkPerson,Integer pageNo,Integer pageSize){
        PageInfo<CheckPerson> checkPersonPageInfo = checkPersonService.selectListByPage(checkPerson, pageNo, pageSize);
        if (null!=checkPersonPageInfo && !"".equals(checkPersonPageInfo)){
            return getSuccess(checkPersonPageInfo);
        }
        return getFiled();
    }
    /**
    * @Description: 分页随机抽查审核人员信息
    * @Param: [put, checkPerson, pageNo, pageSize]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/21
    */
    @PostMapping("/selectPartCheckPersonByPage")
    public ResultData selectPartCheckPersonByPage(Double put, CheckPerson checkPerson,Integer pageNo, Integer pageSize) {
        PageInfo<CheckPerson> personPageInfo = checkPersonService.selectPartCheckPersonByPage(put, checkPerson, pageNo, pageSize);

        if (!"".equals(personPageInfo) && null !=personPageInfo){
            return getSuccess(personPageInfo);
        }
        return getFiled();
    }
    }
