package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.model.Mapping_unit;
import com.aaa.cehui.service.UnitInfoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sbs
 * @date 2020/7/18 16:12
 */
@RestController
public class MappingUtilController extends CommonController<Mapping_unit> {
    @Autowired
    private UnitInfoService unitInfoService;
    @Override
    public BaseService<Mapping_unit> getBaseService() {
        return unitInfoService;
    }

    /**
     * 白名单查询
     * @return
     */
    @RequestMapping("/queryBaiMingDan")
    public List<Mapping_unit> selectBaiByScore(){
        return unitInfoService.queryBaiMingDanByScore();
    }

    /**
     * 黑名单查询
     * @return
     */
    @RequestMapping("/queryHeiMingDan")
    public List<Mapping_unit> selectHeiByScore(){
        return unitInfoService.queryHeiMingDanByScore();
    }

}
