package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.EquipmentMapper;
import com.aaa.cehui.model.Equipment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/17  9:35
 * @Description
 **/
@Service
public class EquimentService extends BaseService<Equipment> {

    @Autowired
    EquipmentMapper equipmentMapper;

    /**
    * @Author LTL
    * @Description 分页查询所有的设备信息
    * @Param [pageNo, pageSize]
    * @Return com.github.pagehelper.PageInfo<com.aaa.cehui.model.Equipment>
    * @DateTime 2020/7/17  16:26
    * @Throws
    */
    public PageInfo<Equipment> selectAllEquiment(Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Equipment> equipment = equipmentMapper.selectAllEquiment();
        if (equipment.size()>0){
            PageInfo<Equipment> pageInfo = new PageInfo<>(equipment);
            return pageInfo;
        }else{
            return null;
        }


    }
}
