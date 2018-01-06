package test;

import java.util.List;
import db_union.news.model.News;
import db_union.news.service.INewsService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import db_union.utils.Page;
import db_union.utils.PageUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestNews {
	private static final Logger logger = Logger.getLogger(TestNews.class);
	//logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	
	private INewsService newsservice;
	
	public INewsService getNewsservice() {
		return newsservice;
	}
	
	@Autowired
	public void setNewsservice(INewsService newsservice) {
		this.newsservice = newsservice;
	}
	@Test
	public void test_insert(){
		
	}
	@Test
	public void test_delete(){
		
	}
	@Test
	public void test_all(){
		int count = newsservice.countAll();
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find(){
		List<News> list= newsservice.findNews_index();
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test_findByPage(){
		Page page = PageUtil.createPage(2, newsservice.countAll(), 1);
		List<Object> list = newsservice.findNewsByPage(page);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
}
