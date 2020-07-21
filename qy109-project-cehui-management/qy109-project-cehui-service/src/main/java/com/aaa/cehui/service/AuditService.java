package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.AuditMapper;
import com.aaa.cehui.model.Audit;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @program: qy109-project-cehui
 * @description: 测绘管理-->项目审核
 * @author: Mr.Wang
 * @create: 2020-07-18 14:52
 **/
@Service
public class AuditService extends BaseService<Audit> {
    @Autowired
    private AuditMapper auditMapper;


    /**
     * @Description: 项目信息中审核记录的查询
     * @Param: []
     * @return: java.util.List<com.aaa.cehui.model.Audit>
     * @Author: Mr.Wang
     * @Date: 2020/7/18
     */
    public List<Audit> getProjectAuditAll(){
        List<Audit> audits = super.selectAll();
        if (audits.size()>0 && audits!=null){
            return audits;
        }
        return null;
    }
    /**
    * @Description: 通过关联业务编号查询项目审核记录
    * @Param: [refId]
    * @return: java.util.List<com.aaa.cehui.model.Audit>
    * @Author: Mr.Wang
    * @Date: 2020/7/18
    */
    public List<Audit> getAuditByRifId(Long refId){
        List<Audit> auditByRifId = auditMapper.getAuditByRifId(refId);
        if (auditByRifId.size()>0 &&auditByRifId!=null){
            return auditByRifId;
        }
        return null;
    }

}
