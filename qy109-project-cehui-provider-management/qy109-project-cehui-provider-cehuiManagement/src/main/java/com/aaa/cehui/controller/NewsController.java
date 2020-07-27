package com.aaa.cehui.controller;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.base.CommonController;
import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.News;
import com.aaa.cehui.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.aaa.cehui.status.OperationStatus.FAILED;
import static com.aaa.cehui.status.OperationStatus.SUCCESS;

/**
 * @author sbs
 * @date 2020/7/18 8:53
 *      测绘管理--公告栏
 */
@RestController
public class NewsController extends CommonController<News> {
    @Autowired
    private NewsService newsService;
    @Override
    public BaseService getBaseService() {
        return newsService;
    }

    /**
     * 查询所有信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/selectAllNews")
    public ResultData selectAllNews(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        List listNews = getBaseService().selectAll(pageNo, pageSize);
        if (listNews != null && listNews.size()>0) {
            return getSuccess(listNews);
        }else {
            return getFiled();
        }
    }

    /**
     * 根据title模糊查询
     * @param title
     * @return
     */
    @PostMapping("/queryByTitle")
    public ResultData queryByTitle(@RequestParam(value = "title",required = false) String title){
        return getSuccess(newsService.queryByTitle(title));
    }

    /**
     * 添加新闻
     * @param news
     * @return
     */
    @PostMapping("/insertNews")
    public ResultData insertNews(News news){
        ResultData resultData=new ResultData();
       int resultNews= newsService.insertNews(news);
        if (resultNews>0) {
            return resultData.setMsg(SUCCESS.getMsg());
        }
            return resultData.setMsg(FAILED.getMsg());
    }

    /**
     * 修改新闻
     * @param news
     * @return
     */
    @PostMapping("/updateNews")
    public ResultData updateNews(News news){
        ResultData resultData=new ResultData();
        int resultNews = newsService.updateNews(news);
        if (resultNews>0) {
            return resultData.setMsg(SUCCESS.getMsg());
        }
        return resultData.setMsg(FAILED.getMsg());
    }
    /**
     * 根据Id删除新闻
     * @param
     * @return
     */
    @PostMapping("/delNews")
    public ResultData deleteNews(Integer id){
        Long Id=new Long(id);
        ResultData resultData=new ResultData();
        Integer delResult = newsService.delNewsById(Id);
        if (delResult >0) {
            return resultData.setMsg(SUCCESS.getMsg());
        }else {
        return resultData.setMsg(FAILED.getMsg());
        }
    }

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    @PostMapping("/deleteByIds")
    public ResultData deleteNewsByIds(List<Integer> ids){
        Integer resultNews = getBaseService().deleteByIds(ids);
        if (resultNews != null) {
            return getSuccess(resultNews);
        }else {
            return getFiled();
        }
    }
}
