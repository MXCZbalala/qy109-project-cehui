package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.News;
import com.aaa.cehui.service.MappingApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "分页查询所有新闻",
            notes = "通过发送当前页面和页面条数参数来分页查询新闻信息")
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
    @ApiOperation(value = "通过标题模糊查询新闻信息",
            notes = "通过发送新闻标题参数来模糊查询新闻信息")
    public ResultData queryByTitle(@RequestParam(value = "title",required = false) String title){
        return mappingApiService.queryByTitle(title);
    }

    /**
     * 添加新闻
     * @param news
     * @return
     */
    @PostMapping("/insertNews")
    @ApiOperation(value = "添加新闻信息",
            notes = "通过发送实体类参数来添加新闻信息")
    public ResultData insertNews(News news){
        return mappingApiService.insertNews(news);
    }

    /**
     * 修改新闻
     * @param news
     * @return
     */
    @PostMapping("/updateNews")
    @ApiOperation(value = "修改新闻信息",
            notes = "通过发送实体类参数来修改新闻信息")
    public ResultData updateNews(News news){
        return mappingApiService.updateNews(news);
    }

    /**
     * 根据Id删除新闻
     * @param
     * @return
     */
    @PostMapping("/delNews")
    @ApiOperation(value = "删除新闻信息",
            notes = "通过发送id参数来删除新闻信息")
    public ResultData deleteNews(Integer id){
        return mappingApiService.deleteNews(id);
    }

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    @PostMapping("/deleteByIds")
    @ApiOperation(value = "批量删除新闻信息",
            notes = "通过发送id集合参数来批量删除新闻信息")
    public ResultData deleteNewsByIds(List<Integer> ids){
        return  mappingApiService.deleteNewsByIds(ids);
    }


}
