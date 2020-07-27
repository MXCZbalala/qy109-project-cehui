package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.ResultCommit;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/27  18:50
 * @Description
 **/
@RestController
@Api(value = "项目汇交", tags = "项目汇交接口")
public class ResultCommitController {

    @Autowired
    private MappingApiService mappingApiService;

    /**
     * @Description: 查询所有项目成果汇交审核
     * @Param: []
     * @return: java.util.List<com.aaa.cehui.model.ResultCommit>
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/selectAllResultCommit")
    @ApiOperation(value = "查询所有项目成果汇交审核",
            notes = "查询所有项目成果汇交审核信息")
    public ResultData selectAllResultCommit(){
        return mappingApiService.selectAllResultCommit();
    }

    /**
     * @Description: 分页查询所有项目成果汇交审核
     * @Param: []
     * @return: java.util.List<com.aaa.cehui.model.ResultCommit>
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/selectAllResultCommitByPage")
    @ApiOperation(value = "分页查询所有项目成果汇交审核",
            notes = "通过发送pageNo，pageSize参数来分页查询所有项目成果汇交审核信息")
    public ResultData selectAllResultCommitByPage(ResultCommit resultCommit,
                                                  @RequestParam("pageNo") Integer pageNo,
                                                  @RequestParam("pageSize") Integer pageSize){
        return mappingApiService.selectAllResultCommitByPage(resultCommit, pageNo, pageSize);
    }

    /**
     * @Description: 通过姓名分页查询所有项目成果汇交审核
     * @Param: [name, PageNo, PageSize, where]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/selectNameResultCommitByPage")
    @ApiOperation(value = "通过姓名分页查询所有项目成果汇交审核",
            notes = "通过发送姓名，pageNo，pageSize参数来分页通过查询所有项目成果汇交审核信息")
    public ResultData selectNameResultCommitByPage(@RequestParam("name") String name,
                                                   @RequestParam("pageNo") Integer pageNo,
                                                   @RequestParam("pageSize") Integer pageSize
    ){
        return mappingApiService.selectNameResultCommitByPage(name, pageNo, pageSize);
    }

}
