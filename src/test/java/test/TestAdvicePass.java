package test;

import db_union.advice.model.Advice;
import db_union.advice.service.IAdvicePassService;
import db_union.advice.service.IAdviceService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import db_union.utils.Page;
import db_union.utils.PageUtil;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })

public class TestAdvicePass {
	private static final Logger logger = Logger.getLogger(TestManage.class);

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private IAdvicePassService advicepassservice;

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private IAdviceService adviceservice;
	
	@Test
	public void test_insert(){
		
	}
	
	@Test
	public void test_delete(){
		
	}
	
	@Test
	public void test_all(){
		
	}
	
	@Test
	public void test_find(){
		List<Advice> list = advicepassservice.findPassAdvice();
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test_findByPage(){
		Page page = PageUtil.createPage(2,adviceservice.countAllPassAdvice(),1);
		List<Advice> advice = advicepassservice.findPassAdviceByPage(page);
		logger.info(JSON.toJSONStringWithDateFormat(advice, "yyyy-MM-dd HH:mm:ss"));
	}
}