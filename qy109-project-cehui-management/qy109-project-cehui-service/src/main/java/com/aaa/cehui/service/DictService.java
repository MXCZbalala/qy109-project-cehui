package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.DictMapper;
import com.aaa.cehui.model.Dict;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: qy109-project-cehui
 * @description:
 *      系统管理--字典管理
 * @author: Mr.Wang
 * @create: 2020-07-16 10:32
 **/
@Service
public class DictService extends BaseService<Dict> {
    @Autowired
    private DictMapper dictMapper;
    /**
    * @Description: 查询字典信息
    * @Param: []
    * @return: java.util.List<com.aaa.cehui.model.Dict>
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    public List<Dict> selectDict(){
        //查询所有的字典信息
        List<Dict> dicts = dictMapper.selectAll();
        //判断查询的的字典信息是否为空
        if (null != dicts && !"".equals(dicts)){
            //不为空，返回查询的结果
            return dicts;
        }else {
            // 为空
            return null;
        }
    }
    /**
    * @Description: 新增字典信息
    * @Param: [dict]
    * @return: java.lang.Integer
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    public Integer addDict(Dict dict){
        //判断新增的信息是否为空
        if (null!=dict){
            //新增的信息不为空
            int insert = dictMapper.insert(dict);
            //判断新增是否成功
            if (insert>0){
                return insert;
            }
        }
        return null;
    }
    /**
    * @Description: 通过主键批量删除字典信息
    * @Param: [dict]
    * @return: java.lang.Integer
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    public Integer deleteDict(List<Integer> dictIds){
        //判断是否有删除的信息
        if (dictIds.size()>0){
            Integer integer = deleteByIds(dictIds);
            //判断是否删除成功
            if (integer>0){
                return integer;
            }
        }
        return null;
    }
    /**
    * @Description: 查询需要修改数据的ID
    * @Param: [dictId]
    * @return: com.aaa.cehui.model.Dict
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    public Dict selectUpdateDict(Long dictId){
        //判断查询的ID是否为空
        if (!"".equals(dictId)){
            Dict dict = dictMapper.selectUpdateDict(dictId);
            //判断是否查询成功
            if (null!=dict&&!"".equals(dict)){
                return dict;
            }
        }
        return null;
    }
    /**
    * @Description: 修改字典信息
    * @Param: [dict]
    * @return: java.lang.Integer
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    public Integer updateDict(Dict dict){
        //判断修改的信息是否为空
        if (null!=dict){
            Integer integer = super.update(dict);
            //判断是否修改成功
            if (integer>0){
                return integer;
            }
        }
        return null;
    }
    /**
    * @Description: 字典的分页查询信息
    * @Param: [dict, pageNo, pageSize]
    * @return: com.github.pagehelper.PageInfo<com.aaa.cehui.model.Dict>
    * @Author: Mr.Wang
    * @Date: 2020/7/16
    */
    public PageInfo<Dict> selectDictByPage(Dict dict,Integer pageNo,Integer pageSize){
        //调用父类的方法进行查询
        PageInfo<Dict> pageInfo = selectListByPage(dict, pageNo, pageSize);
        //判断查询的结果是否为空
        if (null!=pageInfo&& "".equals(pageInfo)){
            //不为空返回结果
            return pageInfo;
        }
        return null;
    }

}
