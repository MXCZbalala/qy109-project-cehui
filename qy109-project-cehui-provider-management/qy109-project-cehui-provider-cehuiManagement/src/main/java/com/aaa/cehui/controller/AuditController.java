package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Audit;
import com.aaa.cehui.service.AuditService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @program: qy109-project-cehui
 * @description:    测绘管理-->项目审核
 * @author: Mr.Wang
 * @create: 2020-07-18 15:10
 **/
@RestController
public class AuditController extends CommonController<Audit> {
    @Autowired
    private AuditService auditService;
    @Override
    public BaseService<Audit> getBaseService() {
        return auditService;
    }
    /**
    * @Description: 项目中审核记录的查询
    * @Param: []
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/18
    */
    @PostMapping("/getProjectAuditAll")
    public ResultData getProjectAuditAll(){
        List<Audit> projectAuditAll = auditService.getProjectAuditAll();
        if (projectAuditAll.size()>0&&null!=projectAuditAll){
            return getSuccess(projectAuditAll);
        }
        return getFiled();
    }
    @PostMapping("/getProjectAuditAllByPage")
    public ResultData getProjectAuditAllByPage(Audit audit,Integer pageNo,Integer pageSize){
        PageInfo<Audit> auditPageInfo = auditService.selectListByPage(audit, pageNo, pageSize);
        if (null!=auditPageInfo && !"".equals(auditPageInfo)){
            return getSuccess(auditPageInfo);
        }
        return getFiled();
    }
    /**
    * @Description: 分页查询通过关联业务编号查询和type=2查询项目审核记录type=4查询项目汇交成功的结果
    * @Param: [refId, pageNo, pageSize, where]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/18
    */
    @PostMapping("/getAuditByRifId")
    public ResultData getAuditByRifId(Long refId,Integer type, Integer pageNo, Integer pageSize, Sqls where){
        PageInfo<Audit> refId1 = auditService.selectListByPageAndFiled(pageNo, pageSize, where.andEqualTo("refId",refId).andEqualTo("type",type),null);
        if (null!=refId1 && !"".equals(refId1)){
            return getSuccess(refId1);
        }
            return null;
    }


}
