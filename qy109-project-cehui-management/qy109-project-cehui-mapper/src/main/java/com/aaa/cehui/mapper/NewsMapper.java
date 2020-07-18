package com.aaa.cehui.mapper;

import com.aaa.cehui.model.News;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author sbs
 * @date 2020/7/18 8:35
 */
public interface NewsMapper extends Mapper<News>{
    List<News> queryByTitle(String title);

    int insertNews(News news);

    int delNewsById(Long id);
}
