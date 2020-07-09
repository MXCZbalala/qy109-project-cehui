package com.aaa.cehui.mapper;


import com.aaa.cehui.model.Audit;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AuditMapper extends Mapper<Audit> {

    List selectAuditInfo();

    List fuzzyQueryAduit(String projectName);
}