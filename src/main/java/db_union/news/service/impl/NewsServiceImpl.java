package db_union.news.service.impl;

import java.util.List;
import db_union.news.dao.NewsMapper;
import db_union.news.model.News;
import db_union.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import db_union.utils.Page;
@Service
public class NewsServiceImpl implements INewsService {

	private NewsMapper newsmapper;

	public NewsMapper getNewsmapper() {
		return newsmapper;
	}

	@Autowired
	public void setNewsmapper(NewsMapper newsmapper) {
		this.newsmapper = newsmapper;
	}

	@Override
	public int insertNews(News news) {
		// TODO Auto-generated method stub
		return newsmapper.insert(news);
	}

	@Override
	public News findByNewsID(Integer NEWSID) {
		// TODO Auto-generated method stub
		return newsmapper.selectByPrimaryKey(NEWSID);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return newsmapper.countAll();
	}

	@Override
	public List<Object> findNewsByPage(Page page) {
		// TODO Auto-generated method stub
		return newsmapper.findNewsByPage(page);
	}

	@Override
	public List<News> findNews_index() {
		// TODO Auto-generated method stub
		return newsmapper.findNewsIndex();
	}

}
