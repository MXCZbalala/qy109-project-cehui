package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseController;
import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Dict;
import com.aaa.cehui.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.aaa.cehui.status.CRUDStatus.*;

/**
 * @program: qy109-project-cehui
 * @description: 字典控制层
 *          系统管理--字典管理
 * @author: Mr.Wang
 * @create: 2020-07-16 11:28
 **/
@RestController
public class DictController extends CommonController<Dict> {
    @Autowired
    private DictService dictService;

    @Override
    public BaseService getBaseService() {
        return dictService;
    }
    /**
    * @Description: 查询所有字典信息
    * @Param: []
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    @PostMapping("/queryAllDict")
    public ResultData selectDict(){
        if (dictService.selectDict().size()>0){
            return getSuccess(dictService.selectDict());
        }
        return getFiled();

    }
    /**
    * @Description: 新增字典信息
    * @Param: []
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    @PostMapping("/addDict")
    public ResultData addDict(Dict dict){
        if (dictService.addDict(dict)>0){
            return addSuccess(dictService.addDict(dict));
        }
        return addFiled();
    }
    /**
    * @Description: 通过主键批量删除字典数据
    * @Param: [dictIds]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    @PostMapping("/deleteDict")
    public ResultData deleteDict(@RequestParam("dictIds") List<Integer> dictIds){
        if (dictService.deleteByIds(dictIds)>0){
            return deleteSuccess(dictService.deleteByIds(dictIds).toString());
        }
        return deleteFiled();
    }
    /**
    * @Description: 查询出需要修改的数据
    * @Param: [dictId]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    @PostMapping("/selectUpdateDict")
    public ResultData selectUpdateDict(@RequestParam("dictId") Long dictId){
        if (!"".equals(dictService.selectUpdateDict(dictId))){
            return getSuccess(dictService.selectUpdateDict(dictId));
        }
        return getFiled();
    }
    /**
    * @Description: 修改查询出来的信息
    * @Param: [dict]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    @PostMapping("/updateDict")
    public ResultData updateDict(Dict dict){
        if (dictService.updateDict(dict)!=null){
            return updateSuccess(dictService.updateDict(dict));
        }
        return updateFiled();
    }
    /**
    * @Description: 字典的分页查询信息
    * @Param: [dict, pageNo, pageSize]
    * @return: com.aaa.cehui.base.ResultData
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    @PostMapping("/selectDictByPage")
    public ResultData selectDictByPage(@RequestBody Dict dict,
                                       @RequestParam("pageNo") Integer pageNo,
                                       @RequestParam("pageSize") Integer pageSize){
        if (!"".equals(dictService.selectDictByPage(dict,pageNo,pageSize))){
            return getSuccess(dictService.selectDictByPage(dict,pageNo,pageSize));
        }
        return getFiled();
    }


}
