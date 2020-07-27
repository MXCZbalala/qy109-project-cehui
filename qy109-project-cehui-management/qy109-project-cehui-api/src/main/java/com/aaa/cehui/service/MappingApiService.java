package com.aaa.cehui.service;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.*;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/27  9:01
 * @Description
 **/
@FeignClient("interface-provider-cehuiManagement")
public interface MappingApiService {

    /**
     * @Description: 项目中审核记录的查询
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/18
     */
    @PostMapping("/getProjectAuditAll")
    ResultData getProjectAuditAll();

    /**
     * @Description: 分页查询项目中审核记录
     * @Param: [audit, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/getProjectAuditAllByPage")
    ResultData getProjectAuditAllByPage(@RequestBody Audit audit,
                                        @RequestParam("pageNo") Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize);

    /**
     * @Description: 分页查询通过关联业务编号查询和type=2
     * 查询项目登记审核记录type=4查询项目成果汇交记录
     * @Param: [refId, pageNo, pageSize, where]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/18
     */
    @PostMapping("/getAuditByRifId")
    ResultData getAuditByRifId(@RequestParam("refId") Long refId,
                               @RequestParam("type") Integer type,
                               @RequestParam("pageNo") Integer pageNo,
                               @RequestParam("pageSize") Integer pageSize);

    /**
     * 根据UserId分页查询审核记录
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/queryAuditByUserIdPage")
    ResultData queryAuditByUserIdPage(@RequestParam("userId") Integer userId,
                                      @RequestParam("pageNo") Integer pageNo,
                                      @RequestParam("pageSize") Integer pageSize);

    /**
     * @Description: 查询所有抽查人员信息
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/selectAllCheckPerson")
    ResultData selectAllCheckPerson();

    /**
     * @Description: 新增抽查人员
     * @Param: [checkPerson]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/addCheckPerson")
    ResultData addCheckPerson(@RequestBody CheckPerson checkPerson);


    /**
     * @Description: 根据抽查比例获取查询人信息
     * @Param: [put]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/selectPartCheckPerson")
    ResultData selectPartCheckPerson(@RequestParam("put") Double put);

    /**
     * @Description: 分页查询所有审核人员信息
     * @Param: [checkPerson, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/selectCheckPersonByPage")
    ResultData selectCheckPersonByPage(@RequestBody CheckPerson checkPerson,
                                       @RequestParam("pageNo") Integer pageNo,
                                       @RequestParam("pageSize") Integer pageSize);

    /**
     * @Description: 分页随机抽查审核人员信息
     * @Param: [put, checkPerson, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/selectPartCheckPersonByPage")
    ResultData selectPartCheckPersonByPage(@RequestBody CheckPerson checkPerson,
                                           @RequestParam("put") Double put,
                                           @RequestParam("pageNo") Integer pageNo,
                                           @RequestParam("pageSize") Integer pageSize);

    /**
     * @Author LTL
     * @Description 分页查询所有设备仪器信息
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/17  9:50
     * @Throws
     */
    @GetMapping("/selectAllEquiment")
    PageInfo selectAllEquiment(@RequestParam("pageNo") Integer pageNo,
                               @RequestParam("pageSize") Integer pageSize);

    /**
     * 通过userID查询设备信息分页
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/queryEquimentByUserIdPage")
    ResultData queryByUserIdPage(@RequestParam("userId") Integer userId,
                                 @RequestParam("pageNo") Integer pageNo,
                                 @RequestParam("pageSize") Integer pageSize);


    /**
     * @Description: 查询所有已经提交的项目
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/selectAllMappingProject")
    ResultData selectAllMappingProject();

    /**
     * @Description: 通过项目类型查询项目
     * @Param: [projectType]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/selectMappingProjectByType")
    ResultData selectMappingProjectByType(@RequestParam("projectType") String projectType);


    /**
     * @Description: 分页通过项目类型查询项目
     * @Param: [projectType, pageNo, pageSize, where]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/selectMappingProjectByTypeByPage")
    ResultData selectMappingProjectByTypeByPage(@RequestParam("projectType") String projectType,
                                                @RequestParam("pageNo") Integer pageNo,
                                                @RequestParam("pageSize") Integer pageSize);


    /**
     * @Description: 分页查询，根据所提交的项目进行分页
     * @Param: [mappingProject, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/selectMappingProjectByPage")
    ResultData selectMappingProjectByPage(@RequestBody MappingProject mappingProject,
                                          @RequestParam("pageNo") Integer pageNo,
                                          @RequestParam("pageSize") Integer pageSize);

    /**
     * @Description: 通过ID修改汇交项目
     * @Param: [mappingProject]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/updateMappingProject")
    ResultData updateMappingProject(@RequestBody MappingProject mappingProject);

    /**
     * 白名单查询
     *
     * @return
     */
    @PostMapping("/queryBaiMingDan")
    List<MappingUnit> selectBaiByScore();

    /**
     * 白名单分页查询
     *
     * @param
     * @param pageNo
     * @param pageSize
     * @param
     * @return
     */
    @PostMapping("/queryBaiMingDanPage")
    ResultData queryBaiMingDan(@RequestParam("pageNo") Integer pageNo,
                               @RequestParam("pageSize") Integer pageSize);

    /**
     * 黑名单查询
     *
     * @return
     */
    @PostMapping("/queryHeiMingDan")
    List<MappingUnit> selectHeiByScore();


    /**
     * 黑名单分页查询
     *
     * @param
     * @param pageNo
     * @param pageSize
     * @param
     * @return
     */
    @PostMapping("/queryHeiMingDanPage")
    ResultData queryHeiMingDan(@RequestParam("pageNo") Integer pageNo,
                               @RequestParam("pageSize") Integer pageSize);

    /**
     * 查询所有单位信息
     *
     * @return
     */
    @PostMapping("/selectAllMappingUtil")
    List<MappingUnit> selectAllMappingUtil();


    /**
     * 查询所有单位信息分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/selectAllMappingUtilPage")
    ResultData selectAllMappingUtilPage(@RequestParam("pageNo") Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize);

    /**
     * 根据单位名称模糊查询单位信息
     *
     * @param name
     * @return
     */
    @PostMapping("/queryAllMappingUtilByName")
    ResultData queryAllMappingUtilByName(@RequestParam("name") String name);


    /**
     * 分页查询所有未检测单位信息
     *
     * @param
     * @param pageNo
     * @param pageSize
     * @param
     * @return
     */
    @PostMapping("/queryMappingUtilByStatus")
    ResultData queryMappingUtilBySyzStatus(@RequestParam("synchronizationStatus") Integer synchronizationStatus,
                                           @RequestParam("pageNo") Integer pageNo,
                                           @RequestParam("pageSize") Integer pageSize);

    /**
     * 修改单位信息
     *
     * @param mapping_unit
     * @return
     */
    @PostMapping("/updateMappingUnit")
    ResultData updateMappingUnit(MappingUnit mapping_unit);

    /**
     * 查询所有信息
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/selectAllNews")
    ResultData selectAllNews(@RequestParam("pageNo") Integer pageNo,
                             @RequestParam("pageSize") Integer pageSize);

    /**
     * 根据title模糊查询
     *
     * @param title
     * @return
     */
    @PostMapping("/queryByTitle")
    ResultData queryByTitle(@RequestParam(value = "title", required = false) String title);

    /**
     * 添加新闻
     *
     * @param news
     * @return
     */
    @PostMapping("/insertNews")
    ResultData insertNews(News news);


    /**
     * 修改新闻
     *
     * @param news
     * @return
     */
    @PostMapping("/updateNews")
    ResultData updateNews(News news);


    /**
     * 根据Id删除新闻
     *
     * @param
     * @return
     */
    @PostMapping("/delNews")
    ResultData deleteNews(Integer id);


    /**
     * 根据id批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/deleteByIds")
    ResultData deleteNewsByIds(List<Integer> ids);


    /**
     * @Author LTL
     * @Description 通过ID查询单个负责人信息
     * @Param [principal]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  21:56
     * @Throws
     */
    @PostMapping("/selectPricipalById")
    ResultData selectPricipalById(Principal principal);


    /**
     * @Author LTL
     * @Description 分页查询所有负责人信息
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:33
     * @Throws
     */
    @PostMapping("/selectAllPricipal")
    ResultData selectAllPricipal(@RequestParam("pageNo") Integer pageNo,
                                 @RequestParam("pageSize") Integer pageSize);


    /**
     * @Author LTL
     * @Description 增加一个负责人信息
     * @Param [principal]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:33
     * @Throws
     */
    @PostMapping("/addPricipal")
    ResultData addPricipal(Principal principal);


    /**
     * @Author LTL
     * @Description 修改单个负责人信息
     * @Param [principal]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:33
     * @Throws
     */
    @PostMapping("/updatePricipal")
    ResultData updatePricipal(Principal principal);

    /**
     * @Author LTL
     * @Description 删除单个负责人信息
     * @Param [principal]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:33
     * @Throws
     */
    @PostMapping("/deletePricipal")
    ResultData deletePricipal(Principal principal);

    /**
     * 根据userId查询负责人信息
     *
     * @param
     * @return
     */
    @PostMapping("/queryPrincipalByUserId")
    List<Principal> selectByUserId(@RequestParam("userId") Integer userId);

    /**
     * @Description: 项目信息的查询
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/18
     */
    @PostMapping("/selectAllProject")
    ResultData selectAllProject();


    /**
     * @Description: 项目信息的分页查询
     * @Param: [projectInfo, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/18
     */
    @PostMapping("/selectAllProjectByPage")
    ResultData selectAllProjectByPage(ProjectInfo projectInfo,
                                      @RequestParam("pageNo") Integer pageNo,
                                      @RequestParam("pageSize") Integer pageSize);

    /**
     * @Description: 项目信息通过项目名称模糊查询
     * @Param: [projectName]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/18
     */
    @PostMapping("/getLikeProjectIno")
    ResultData getLikeProjectIno(@RequestParam("projectName") String projectName);


    /**
     * @Description: 分页项目信息通过项目名称模糊查询
     * @Param: [projectName, pageNo, pageSize, where]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/getLikeProjectInoByPage")
    ResultData getLikeProjectInoByPage(@RequestParam("projectName") String projectName,
                                       @RequestParam("pageNo") Integer pageNo,
                                       @RequestParam("pageSize") Integer pageSize);


    /**
     * @Author LTL
     * @Description 通过单位ID查询单位附件信息
     * @Param [unitId]
     * @Return java.util.List<com.aaa.cehui.model.Resource>
     * @DateTime 2020/7/21  16:32
     * @Throws
     */
    @PostMapping("/selectAllResourceByUnitId")
    ResultData selectAllResourceByUnitId(@RequestParam("unitId") Long unitId);

    /**
     * @Author LTL
     * @Description 通过单位信息ID, 上传文件参数
     * @Param [file, unitId]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/21  17:10
     * @Throws
     */
    @PostMapping("/addFileByUnitId")
    ResultData addFileByUnitId(@RequestParam("file") MultipartFile file,
                               @RequestParam("refBizType") String refBizType,
                               @RequestParam("unitId") Long unitId);


    /**
     * @Description: 查询所有项目成果汇交审核
     * @Param: []
     * @return: java.util.List<com.aaa.cehui.model.ResultCommit>
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/selectAllResultCommit")
    ResultData selectAllResultCommit();

    /**
     * @Description: 分页通过查询所有项目成果汇交审核
     * @Param: []
     * @return: java.util.List<com.aaa.cehui.model.ResultCommit>
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/selectAllResultCommitByPage")
    ResultData selectAllResultCommitByPage(ResultCommit resultCommit,
                                           @RequestParam("pageNo") Integer pageNo,
                                           @RequestParam("pageSize") Integer pageSize);


    /**
     * @Description: 通过姓名分页查询所有项目成果汇交审核
     * @Param: [name, PageNo, PageSize, where]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/20
     */
    @PostMapping("/selectNameResultCommitByPage")
    ResultData selectNameResultCommitByPage(@RequestParam("name") String name,
                                            @RequestParam("pageNo") Integer pageNo,
                                            @RequestParam("pageSize") Integer pageSize);

    /**
     * 查询所有打分记录分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/selectAllScorePage")
    ResultData selectAllScorePage(@RequestParam("pageNo") Integer pageNo,
                                  @RequestParam("pageSize") Integer pageSize);

    /**
     * 添加打分记录
     * 并修改mapping_util中关于score和until_status的值
     *
     * @param score
     * @return
     */
    @PostMapping("/insertScore")
    ResultData insertScore(Score score);


    /**
     * @Author LTL
     * @Description 分页查询所有的技术人员信息
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:35
     * @Throws
     */
    @GetMapping("/selectAllSpecialPost")
    ResultData selectAllSpecialPost(@RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize);

    /**
     * @Author LTL
     * @Description 添加一条技术人员信息
     * @Param [specialPost]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:35
     * @Throws
     */
    @PostMapping("/addSpecialPost")
    ResultData addSpecialPost(SpecialPost specialPost);


    /**
     * @Author LTL
     * @Description 通过主键删除技术人员信息
     * @Param [specialPost]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:36
     * @Throws
     */
    @PostMapping("/deleteSpecialPostById")
    ResultData deleteSpecialPostById(SpecialPost specialPost);

    /**
     * @Author LTL
     * @Description 通过主键修改技术人员信息
     * @Param [specialPost]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:36
     * @Throws
     */
    @PostMapping("/updateSpecialPostById")
    ResultData updateSpecialPostById(SpecialPost specialPost);


    /**
     * 通过userId查询特殊岗位人员
     *
     * @param userId
     * @return
     */
    @PostMapping("/queryByUserId")
    ResultData queryByUserId(@RequestParam("userId") Integer userId);

    /**
     * @Author LTL
     * @Description 分页查询所有技术人员信息
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:34
     * @Throws
     */
    @PostMapping("/selectAllTechnicist")
    ResultData selectAllTechnicist(@RequestParam("pageNo") Integer pageNo,
                                   @RequestParam("pageSize") Integer pageSize);

    /**
     * @Author LTL
     * @Description 通过ID查询技术人员信息
     * @Param [technicist]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:34
     * @Throws
     */
    @PostMapping("/selectTechnicistById")
    ResultData selectTechincistById(Technicist technicist);


    /**
     * @Author LTL
     * @Description 通过ID修改单个技术人员信息
     * @Param [technicist]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:34
     * @Throws
     */
    @PostMapping("/updateTechnicistById")
    ResultData updateTechnicistById(Technicist technicist);


    /**
     * @Author LTL
     * @Description 通过ID删除单个技术人员信息
     * @Param [technicist]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  22:35
     * @Throws
     */
    @PostMapping("/deleteTechnicistById")
    ResultData deleteTechnicistById(Technicist technicist);


    /**
     * 通过userID查询技术人员分页
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/queryTechnicistByUserIdPage")
    ResultData queryTechnicistByUserIdPage(@RequestParam("userId") Integer userId,
                                           @RequestParam("pageNo") Integer pageNo,
                                           @RequestParam("pageSize") Integer pageSize);

    /**
     * @Description: 分页查询单位抽查
     * @Param: [mappingUnit, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/selectUnitByPage")
    ResultData selectUnitByPage(MappingUnit mappingUnit,
                                @RequestParam("pageNo") Integer pageNo,
                                @RequestParam("pageSize") Integer pageSize);

    /**
     * @Description: 分页通过抽查比例查询单位信息
     * @Param: [ownedDistrict, put, mappingUnit, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/21
     */
    @PostMapping("/selectPartUnitByPage")
    ResultData selectPartUnitByPage(@RequestBody MappingUnit mappingUnit,
                                    @RequestParam(value = "ownedDistrict") String ownedDistrict,
                                    @RequestParam("put") Double put,
                                    @RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize);

    /**
     * @Author LTL
     * @Description 根据登录账号查询所属单位基本信息
     * @Param [id]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/16  20:10
     * @Throws
     */
    @PostMapping("/selectUnitInfoById")
    ResultData selectUnitInfoById(@RequestParam("id") Long id);

    /**
     * @Description: 查询所有项目的信息
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/selectAllInfo")
    ResultData selectAllInfo();

    /**
     * @Description: 通过主键ID查询项目
     * @Param: [id]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/selectProjectInfoById")
    ResultData selectProjectInfoById(Long id);

    /**
     * @Description: 新增项目
     * @Param: [projectInfo]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/addProjectInfo")
    ResultData addProjectInfo(ProjectInfo projectInfo);

    /**
     * @Description: 通过ID修改项目
     * @Param: []
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/updateProjectInfoById")
    ResultData updateProjectInfoById(ProjectInfo projectInfo);


    /**
     * @Description: 通过项目类型查询项目
     * @Param: [projectType]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/getInfoType")
    ResultData getInfoType(String projectType);

    /**
     * @Description: 项目管理的分页查询
     * @Param: [projectInfo, pageNo, pageSize]
     * @return: com.aaa.cehui.base.ResultData
     * @Author: Mr.Wang
     * @Date: 2020/7/17
     */
    @PostMapping("/selectProjectByPage")
    ResultData selectProjectByPage(ProjectInfo projectInfo,
                                   @RequestParam("pageNo") Integer pageNo,
                                   @RequestParam("pageSize") Integer pageSize);

}
