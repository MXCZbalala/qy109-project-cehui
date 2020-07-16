package com.aaa.cehui.service;

import com.aaa.cehui.properties.FtpProperties;
import com.aaa.cehui.utils.FileNameUtils;
import com.aaa.cehui.utils.FtpUtils;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

import static com.aaa.cehui.staticproperties.RedisProperties.POINT;
import static com.aaa.cehui.staticproperties.TimeForatProperties.DATE_FORMAT;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/7/10 11:44
 * @Description
 **/
@Service
public class UploadService {

    @Autowired
    private FtpProperties ftpProperties;

    /**
     * @author Seven Lee
     * @description
     *      文件上传
     * @param [file]
     * @date 2020/7/10
     * @return java.lang.Boolean
     * @throws
    **/
    public Boolean upload(MultipartFile file) {
        // 1.获取文件的远程名称(为了获取后缀名)
        String oleFileName = file.getOriginalFilename();
        // 2.生成新的文件名
        String newFileName = FileNameUtils.getFileName();
        // 3.截取后缀名，拼接到新的文件名上
        newFileName = newFileName + oleFileName.substring(oleFileName.lastIndexOf(POINT));
        // 4.获取文件的上传路径(2020/07/10)
        // TODO 暂时没有完成，目前使用的是apache开源基金会的日期工具类，不符合咱们团队的技术水平，需要自己手动编写
        String filePath = DateUtil.formatDate(new Date(), DATE_FORMAT);
        // 5.调用文件上传工具类
        try {
            return FtpUtils.upload(ftpProperties.getHost(), ftpProperties.getPort(), ftpProperties.getUsername(),
                    ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newFileName, file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
