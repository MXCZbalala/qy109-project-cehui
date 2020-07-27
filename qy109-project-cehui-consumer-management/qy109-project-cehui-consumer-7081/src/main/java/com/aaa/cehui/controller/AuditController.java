package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Audit;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ltl
 * @Date 2020/7/27  11:25
 * @Description
 **/
@RestController
@Api(value = "项目审核", tags = "项目信息")
public class AuditController {
    @Autowired
    private MappingApiService mappingApiService;

    /**
     * @Description: 项目中审核记录的查询
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/18
     */
    @PostMapping("/getProjectAuditAll")
    @ApiOperation(value = "项目中审核记录的查询",
            notes = "查询项目中所有审核记录的查询")
    public ResultData getProjectAuditAll(){
        return mappingApiService.getProjectAuditAll();
    }

    /**
     * @Description: 分页查询项目中审核记录
     * @Param: [audit, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/getProjectAuditAllByPage")
    @ApiOperation(value = "分页查询项目中审核记录",
            notes = "通过发送pageNo，pageSize，参数来分页查询项目中审核记录")
    public ResultData getProjectAuditAllByPage(@RequestBody Audit audit,
                                               @RequestParam("pageNo") Integer pageNo,
                                               @RequestParam("pageSize") Integer pageSize
    ){
        return mappingApiService.getProjectAuditAllByPage(audit, pageNo, pageSize);
    }
    /**
     * @Description: 分页查询通过关联业务编号查询和type=2查询项目登记审核记录type=4查询项目成果汇交记录
     * @Param: [refId, pageNo, pageSize, where]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/18
     */
    @PostMapping("/getAuditByRifId")
    @ApiOperation(value = "分页查询通过关联业务编号查询",
            notes = "通过发送pageNo，pageSize，管理业务编号和类型参数来分页查询项目成果汇交记录")
    public ResultData getAuditByRifId(@RequestParam("refId") Long refId,
                                      @RequestParam("type") Integer type,
                                      @RequestParam("pageNo") Integer pageNo,
                                      @RequestParam("pageSize") Integer pageSize
    ){
        return mappingApiService.getAuditByRifId(refId, type, pageNo, pageSize);
    }

    /**
     * 根据UserId分页查询审核记录
     * @param userId
     * @param pageNo
     * @param pageSize
     * @param
     * @return
     */
    @PostMapping("/queryAuditByUserIdPage")
    @ApiOperation(value = "根据UserId分页查询审核记录",
            notes = "通过发送pageNo，pageSize，userid分页查询审核记录")
    public ResultData queryAuditByUserIdPage(@RequestParam("userId") Integer userId,
                                             @RequestParam("pageNo")Integer pageNo,
                                             @RequestParam("pageSize")Integer pageSize
    ){
        return mappingApiService.queryAuditByUserIdPage(userId, pageNo, pageSize);
    }



}
