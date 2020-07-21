package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.ResourceMapper;
import com.aaa.cehui.model.Resource;
import com.aaa.cehui.utils.FtpUtils;
import com.aaa.cehui.utils.DateUtils;
import com.aaa.cehui.utils.FileNameUtils;
import com.aaa.cehui.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

import static com.aaa.cehui.staticproperties.TimeForatProperties.TIME_FORMAT;

/**
 * @Author ltl
 * @Date 2020/7/21  16:30
 * @Description
 **/
@Service
public class ResourceService extends BaseService<Resource> {
    @Autowired
    private ResourceMapper resourceMapper;


    /**
    * @Author LTL
    * @Description 通过单位ID获取文件信息
    * @Param [unitId]
    * @Return java.util.List<com.aaa.cehui.model.Resource>
    * @DateTime 2020/7/21  17:11
    * @Throws
    */
    public List<Resource> selectAllResourceByUnitId (Long unitId){
        List<Resource> resources = resourceMapper.selectAllResourceByUnitId(unitId);
        return resources;
    }

    /**
    * @Author LTL
    * @Description 通过单位ID上传文件
    * @Param [file, unitId, uploadService]
    * @Return java.lang.Object
    * @DateTime 2020/7/21  17:11
    * @Throws
    */
    public Object addFileByUnitId(MultipartFile file,Long unitId,String refBizType,UploadService uploadService){

        //TODO  文件上传业务
       return null;
    }
}
