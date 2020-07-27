package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.News;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ltl
 * @Date 2020/7/27  16:53
 * @Description
 **/
@RestController
@Api(value = "新闻管理", tags = "新闻")
public class NewsController {
    @Autowired
    private MappingApiService mappingApiService;

    /**
     * 查询所有信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/selectAllNews")
    public ResultData selectAllNews(@RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize){
        return mappingApiService.selectAllNews(pageNo, pageSize);
    }

    /**
     * 根据title模糊查询
     * @param title
     * @return
     */
    @PostMapping("/queryByTitle")
    public ResultData queryByTitle(@RequestParam(value = "title",required = false) String title){
        return mappingApiService.queryByTitle(title);
    }

    /**
     * 添加新闻
     * @param news
     * @return
     */
    @PostMapping("/insertNews")
    public ResultData insertNews(News news){
        return mappingApiService.insertNews(news);
    }

    /**
     * 修改新闻
     * @param news
     * @return
     */
    @PostMapping("/updateNews")
    public ResultData updateNews(News news){
        return mappingApiService.updateNews(news);
    }

    /**
     * 根据Id删除新闻
     * @param
     * @return
     */
    @PostMapping("/delNews")
    public ResultData deleteNews(Integer id){
        return mappingApiService.deleteNews(id);
    }

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    @PostMapping("/deleteByIds")
    public ResultData deleteNewsByIds(List<Integer> ids){
        return  mappingApiService.deleteNewsByIds(ids);
    }


}
