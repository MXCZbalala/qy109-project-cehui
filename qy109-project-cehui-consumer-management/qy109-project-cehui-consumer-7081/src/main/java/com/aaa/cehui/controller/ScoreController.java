package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Score;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/27  18:52
 * @Description
 **/
@RestController
@Api(value = "项目评审", tags = "项目评审")
public class ScoreController {

    @Autowired
    private MappingApiService mappingApiService;

    /**
     * 查询所有打分记录分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/selectAllScorePage")
    public ResultData selectAllScorePage(@RequestParam("pageNo")Integer pageNo,
                                         @RequestParam("pageSize") Integer pageSize){
        return mappingApiService.selectAllScorePage(pageNo, pageSize);
    }

    /**
     * 添加打分记录
     * 并修改mapping_util中关于score和until_status的值
     * @param score
     * @return
     */
    @PostMapping("/insertScore")
    public ResultData insertScore(Score score){
        return mappingApiService.insertScore(score);
    }
}
