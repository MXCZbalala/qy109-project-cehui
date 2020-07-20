package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Technicist;
import com.aaa.cehui.service.TechnicistService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/16  22:00
 * @Description
 *      测绘管理--单位基本信息---技术人员信息
 **/
@RestController
public class TechnicistController extends CommonController<Technicist> {

    @Autowired
    TechnicistService technicistService;
    @Override
    public BaseService<Technicist> getBaseService() {
        return technicistService;
    }


    /**
    * @Author LTL
    * @Description 分页查询所有技术人员信息
    * @Param [pageNo, pageSize]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  22:34
    * @Throws
    */
    @PostMapping("/selectAllTechnicist")
    public ResultData selectAllTechnicist(@RequestParam("pageNo") Integer pageNo,
                                          @RequestParam("pageSize") Integer pageSize
    ){
        List<Technicist> technicists = getBaseService().selectAll(pageNo, pageSize);
        return getSuccess(technicists);
    }

    /**
    * @Author LTL
    * @Description 通过ID查询技术人员信息
    * @Param [technicist]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  22:34
    * @Throws
    */
    @PostMapping("/selectTechnicistById")
    public ResultData selectTechincistById(Technicist technicist){
        Technicist technicist1 = getBaseService().selectOne(technicist);
        if (null !=technicist1){
            return getSuccess(technicist);
        }
        else {
            return getFiled("未找到!");
        }
    }

    /**
    * @Author LTL
    * @Description 通过ID修改单个技术人员信息
    * @Param [technicist]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  22:34
    * @Throws
    */
    @PostMapping("/updateTechnicistById")
    public ResultData updateTechnicistById(Technicist technicist){
        Integer update = getBaseService().update(technicist);
        if (update>0){
            return updateSuccess();
        }else {
            return updateFiled();
        }
    }

    /**
    * @Author LTL
    * @Description 通过ID删除单个技术人员信息
    * @Param [technicist]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/16  22:35
    * @Throws
    */
    @PostMapping("/deleteTechnicistById")
    public ResultData deleteTechnicistById(Technicist technicist){
        Integer delete = getBaseService().delete(technicist);
        if (delete>0){
            return updateSuccess();
        }else {
            return updateFiled();
        }
    }

    /**
     * 通过userID查询技术人员分页
     * @param userId
     * @param pageNo
     * @param pageSize
     * @param where
     * @return
     */
    @PostMapping("/queryTechnicistByUserIdPage")
    public ResultData queryByUserIdPage(@RequestParam("userId") Integer userId,
                                        @RequestParam("pageNo") Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize, Sqls where){
        PageInfo<Technicist> userId1 = technicistService.selectListByPageAndFiled(pageNo, pageSize, where.andEqualTo("userId", userId), null, null);

        if (userId1 != null) {
            return getSuccess(userId1);
        }
        return getFiled();
    }
}
