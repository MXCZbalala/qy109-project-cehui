package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Principal;
import com.aaa.cehui.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/16  20:23
 * @Description
 *      测绘管理--单位基本信息--负责人信息
 **/
@RestController
public class PrincipalController extends CommonController<Principal> {

    @Autowired
    PrincipalService principalService;

    public BaseService<Principal> getBaseService() {
        return principalService;
    }

    /**
    * @Author LTL
    * @Description 通过ID查询单个负责人信息
    * @Param [principal]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  21:56
    * @Throws
    */
    @PostMapping("/selectPricipalById")
    public ResultData selectPricipalById(Principal principal){
        return getSuccess(getBaseService().selectOne(principal));
    }

    /**
    * @Author LTL
    * @Description 分页查询所有负责人信息
    * @Param [pageNo, pageSize]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  22:33
    * @Throws
    */
    @PostMapping("/selectAllPricipal")
    public ResultData selectAllPricipal(@RequestParam("pageNo") Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize
    ){
        List<Principal> principals = getBaseService().selectAll(pageNo, pageSize);
        if (null != principals){
            return getSuccess(principals);
        }else {
            return getFiled();
        }
    }

    /**
    * @Author LTL
    * @Description 增加一个负责人信息
    * @Param [principal]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  22:33
    * @Throws
    */
    @PostMapping("/addPricipal")
    public ResultData addPricipal(Principal principal){
        Integer add = getBaseService().add(principal);
        if (add > 0){
            return addSuccess();
        }else {
            return addFiled();
        }
    }
    /**
    * @Author LTL
    * @Description 修改单个负责人信息
    * @Param [principal]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  22:33
    * @Throws
    */
    @PostMapping("/updatePricipal")
    public ResultData updatePricipal(Principal principal){
        Integer update = getBaseService().update(principal);
        if (update > 0){
            return updateSuccess();
        }else {
            return updateFiled();
        }
    }

    /**
    * @Author LTL
    * @Description 删除单个负责人信息
    * @Param [principal]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  22:33
    * @Throws
    */
    @PostMapping("/deletePricipal")
    public ResultData deletePricipal(Principal principal){
        Integer delete = getBaseService().delete(principal);
        if (delete > 0 ){
            return deleteSuccess();
        }else {
            return deleteFiled();
        }
    }
}
