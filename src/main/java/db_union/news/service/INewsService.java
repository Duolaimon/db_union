package db_union.news.service;

import java.util.List;

import db_union.news.model.News;
import db_union.utils.Page;

public interface INewsService {
	
	//
	public int insertNews(News news);
	
	//
	public News findByNewsID(Integer NEWSID);
	
	//
	public int countAll();
	
	//
	public List<Object> findNewsByPage(Page page);
	
	//
	public List<News> findNews_index();
}
