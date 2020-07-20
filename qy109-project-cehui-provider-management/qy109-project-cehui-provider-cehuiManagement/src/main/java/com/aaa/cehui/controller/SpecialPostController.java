package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.SpecialPost;
import com.aaa.cehui.service.SpecialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/16  22:16
 * @Description
 *      特殊岗位人员信息表的增删改查
 **/
public class SpecialPostController extends CommonController<SpecialPost> {

    @Autowired
    SpecialPostService specialPostService;


    @Override
    public BaseService<SpecialPost> getBaseService() {
        return specialPostService;
    }

    /**
    * @Author LTL
    * @Description 分页查询所有的技术人员信息
    * @Param [pageNo, pageSize]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  22:35
    * @Throws
    */
    @GetMapping("/selectAllSpecialPost")
    public ResultData selectAllSpecialPost(@RequestParam("pageNo") Integer pageNo,
                                           @RequestParam("pageSize") Integer pageSize
    ){

        List<SpecialPost> specialPosts = getBaseService().selectAll(pageNo, pageSize);
        if (null != specialPosts){
            return getSuccess(specialPosts);
        }else {
            return getFiled();
        }

    }
    /**
    * @Author LTL
    * @Description 添加一条技术人员信息
    * @Param [specialPost]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  22:35
    * @Throws
    */
    @PostMapping("/addSpecialPost")
    public ResultData addSpecialPost(SpecialPost specialPost){
        Integer add = getBaseService().add(specialPost);
        if (add > 0){
            return addSuccess();
        }else {
            return addFiled();
        }
    }

    /**
    * @Author LTL
    * @Description 通过主键删除技术人员信息
    * @Param [specialPost]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  22:36
    * @Throws
    */
    @PostMapping("/deleteSpecialPostById")
    public ResultData deleteSpecialPostById(SpecialPost specialPost){
        Integer delete = getBaseService().delete(specialPost);
        if (delete > 0){
            return deleteSuccess();
        }else {
            return deleteFiled();
        }
    }

    /**
    * @Author LTL
    * @Description 通过主键修改技术人员信息
    * @Param [specialPost]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  22:36
    * @Throws
    */
    @PostMapping("/updateSpecialPostById")
    public ResultData updateSpecialPostById(SpecialPost specialPost){
        Integer update = getBaseService().update(specialPost);
        if (update > 0){
            return updateSuccess();
        }else {
            return updateFiled();
        }
    }
    /**
     * 通过userId查询特殊岗位人员
     * @param userId
     * @return
     */
    @PostMapping("/queryByUserId")
    public ResultData queryByUserId(@RequestParam("userId") Integer userId){
        Long userId1=new Long(userId);
        List<SpecialPost> specialPosts = specialPostService.queryByUserId(userId1);
        if (specialPosts.size()>0) {
            return getSuccess(specialPosts);
        }else {
            return getFiled();
        }
    }
}
