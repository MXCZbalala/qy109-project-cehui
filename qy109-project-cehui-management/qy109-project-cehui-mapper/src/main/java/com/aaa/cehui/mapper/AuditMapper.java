package com.aaa.cehui.mapper;


import com.aaa.cehui.model.Audit;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AuditMapper extends Mapper<Audit> {

    List selectAuditInfo();

    List fuzzyQueryAduit(String projectName);
    @Select("select * from t_audit where type=2 and ref_id =#{refId}")
    List<Audit> getAuditByRifId(Long refId);
}