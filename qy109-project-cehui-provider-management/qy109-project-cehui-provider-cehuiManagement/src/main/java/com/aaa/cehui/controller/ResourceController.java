package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Resource;
import com.aaa.cehui.service.ResourceService;
import com.aaa.cehui.service.UploadService;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/21  16:28
 * @Description 测绘管理--单位基本信息--附件
 **/
@RestController
public class ResourceController extends CommonController<Resource> {
    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UploadService uploadService;

    public BaseService<Resource> getBaseService() {
        return resourceService;
    }


    /**
     * @Author LTL
     * @Description 通过单位ID查询单位附件信息
     * @Param [unitId]
     * @Return java.util.List<com.aaa.cehui.model.Resource>
     * @DateTime 2020/7/21  16:32
     * @Throws
     */
    @PostMapping("/selectAllResourceByUnitId")
    public ResultData selectAllResourceByUnitId(@RequestParam("unitId") Long unitId) {
        return resourceService.selectAllResourceByUnitId(unitId).size() > 0
                ? getSuccess(resourceService.selectAllResourceByUnitId(unitId))
                : getFiled("数据未找到");
    }

    /**
    * @Author LTL
    * @Description 通过单位信息ID,上传文件参数
    * @Param [file, unitId]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/21  17:10
    * @Throws
    */
    @PostMapping("/addFileByUnitId")
    public ResultData addFileByUnitId(@RequestParam("file") MultipartFile file,
                                      @RequestParam("refBizType") String refBizType,
                                      @RequestParam("unitId") Long unitId){
        return null;
        //TODO 文件上传

    }
}
