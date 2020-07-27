package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Technicist;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/27  18:57
 * @Description
 **/
@RestController
@Api(value = "技术人员信息", tags = "技术人员信息")
public class TechnicistController {

    @Autowired
    private MappingApiService mappingApiService;


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
        return mappingApiService.selectAllTechnicist(pageNo, pageSize);
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
        return mappingApiService.selectTechincistById(technicist);
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
        return mappingApiService.updateTechnicistById(technicist);
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
        return mappingApiService.deleteTechnicistById(technicist);
    }

    /**
     * 通过userID查询技术人员分页
     * @param userId
     * @param pageNo
     * @param pageSize
     * @param
     * @return
     */
    @PostMapping("/queryTechnicistByUserIdPage")
    public ResultData queryTechnicistByUserIdPage(@RequestParam("userId") Integer userId,
                                                  @RequestParam("pageNo") Integer pageNo,
                                                  @RequestParam("pageSize") Integer pageSize){
        return mappingApiService.queryTechnicistByUserIdPage(userId, pageNo, pageSize);
    }


}
