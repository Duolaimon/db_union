package db_union.news.dao;

import java.util.List;

import db_union.news.model.News;
import db_union.utils.Page;

public interface NewsMapper {
	
    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
    
    //
    int countAll();
    
    //
    List<Object> findNewsByPage(Page page);
    
    //
    List<News> findNewsIndex();
}