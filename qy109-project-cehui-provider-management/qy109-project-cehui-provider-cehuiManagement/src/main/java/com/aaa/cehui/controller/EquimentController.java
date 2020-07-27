package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseController;
import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Equipment;
import com.aaa.cehui.model.Technicist;
import com.aaa.cehui.service.EquimentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/17  9:35
 * @Description
 **/
@RestController
public class EquimentController extends CommonController<Equipment> {

    @Autowired
    private EquimentService equimentService;

    @Override
    public BaseService<Equipment> getBaseService() {
        return equimentService;
    }


    /**
    * @Author LTL
    * @Description 分页查询所有设备仪器信息
    * @Param [pageNo, pageSize]
    * @Return com.aaa.cehui.base.ResultData
    * @DateTime 2020/7/17  9:50
    * @Throws
    */
    @GetMapping("/selectAllEquiment")
    public PageInfo selectAllEquiment(@RequestParam("pageNo") Integer pageNo,
                                      @RequestParam("pageSize")Integer pageSize
    ){
       return equimentService.selectAllEquiment(pageNo,pageSize);

    }
    /**
     * 通过userID查询设备信息分页
     * @param userId
     * @param pageNo
     * @param pageSize
     * @param where
     * @return
     */
    @PostMapping("/queryEquimentByUserIdPage")
    public ResultData queryByUserIdPage(@RequestParam("userId") Integer userId,
                                        @RequestParam("pageNo") Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize){
        PageInfo<Equipment> userId1 = equimentService.selectListByPageAndFiled(pageNo, pageSize, Sqls.custom().andEqualTo("userId", userId), null, null);
        if (userId1 != null) {
            return getSuccess(userId1);
        }
        return getFiled();
    }
}
