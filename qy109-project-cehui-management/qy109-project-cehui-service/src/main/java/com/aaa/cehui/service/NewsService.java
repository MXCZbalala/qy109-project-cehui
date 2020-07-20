package com.aaa.cehui.service;

import com.aaa.cehui.base.BaseService;
import com.aaa.cehui.mapper.NewsMapper;
import com.aaa.cehui.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sbs
 * @date 2020/7/18 8:52
 */
@Service
public class NewsService extends BaseService<News> {
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 根据标题模糊查询
     * @param title
     * @return
     */
    public List<News> queryByTitle(String title){
        return newsMapper.queryByTitle(title);
    }

    /**
     * 新增新闻
     * @param news
     * @return
     */
    public int insertNews(News news){
        return newsMapper.insertNews(news);
    }

    /**
     * 删除新闻
     * @param id
     * @return
     */
    public int delNewsById(Long id){
        return newsMapper.delNewsById(id);
    }
}
