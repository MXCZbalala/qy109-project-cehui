package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.ResultCommitMapper;
import com.aaa.cehui.model.ResultCommit;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: qy109-project-cehui
 * @description:        测绘管理-->项目审核-->成果汇交审核
 * @author: Mr.Wang
 * @create: 2020-07-20 18:40
 **/
@Service
public class ResultCommitService extends BaseService<ResultCommit> {
    @Autowired
    private ResultCommitMapper resultCommitMapper;
    /**
    * @Description: 查询所有项目成果汇交审核
    * @Param: []
    * @return: java.util.List<com.aaa.cehui.model.ResultCommit>
    * @Author: Mr.Wang
    * @Date: 2020/7/20
    */
    public List<ResultCommit> selectAllResultCommit(){
        List<ResultCommit> resultCommits = resultCommitMapper.selectAll();
        if (resultCommits.size()>0 && null!=resultCommits){
            return resultCommits;
        }
        return null;
    }

}
