package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.ResultCommit;
import com.aaa.cehui.service.ResultCommitService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @program: qy109-project-cehui
 * @description:        测绘管理-->项目审核-->成果汇交审核
 * @author: Mr.Wang
 * @create: 2020-07-20 19:12
 **/
@RestController
public class ResultCommitController extends CommonController<ResultCommit> {
    @Autowired
    private ResultCommitService commitService;
    @Override
    public BaseService<ResultCommit> getBaseService() {
        return commitService;
    }
    /**
     * @Description: 查询所有项目成果汇交审核
     * @Param: []
     * @return: java.util.List<com.aaa.cehui.model.ResultCommit>
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/selectAllResultCommit")
    public ResultData selectAllResultCommit(){
        List<ResultCommit> resultCommits = commitService.selectAll();
        if (resultCommits.size()>0 && null!=resultCommits){
            return getSuccess(resultCommits);
        }
        return getFiled();
    }
    /**
     * @Description: 分页查询所有项目成果汇交审核
     * @Param: []
     * @return: java.util.List<com.aaa.cehui.model.ResultCommit>
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/selectAllResultCommitByPage")
    public ResultData selectAllResultCommitByPage(ResultCommit resultCommit, @RequestParam("pageNo") Integer pageNo,
                                                  @RequestParam("pageSize") Integer pageSize){
        PageInfo<ResultCommit> commitPageInfo = commitService.selectListByPage(resultCommit, pageNo, pageSize);
        if (null!=commitPageInfo && !"".equals(commitPageInfo)){
            return getSuccess(commitPageInfo);
        }
        return getFiled();
    }
    /**
    * @Description: 通过条件分页查询所有项目成果汇交审核
    * @Param: [name, PageNo, PageSize, where]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/20
    */
    @PostMapping("/selectNameResultCommitByPage")
    public ResultData selectNameResultCommitByPage(@RequestParam("name") String name, @RequestParam("pageNo") Integer pageNo,
                                                   @RequestParam("pageSize") Integer pageSize, Sqls where){
        PageInfo<ResultCommit> pageInfo = commitService.selectListByPageAndFiled(pageNo, pageSize, where.andEqualTo("name", name), null);
        if (null!=pageInfo && !"".equals(pageInfo)){
            return getSuccess(pageInfo);
        }
        return getFiled();
    }
}
