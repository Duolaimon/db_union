package test;

import db_union.manage.model.Manage;
import db_union.manage.service.IManageService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestManage {

	private static final Logger logger = Logger.getLogger(TestManage.class);
	
	private IManageService manageservice;

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	public void setManageservice(IManageService manageservice) {
		this.manageservice = manageservice;
	}

	@Test
	public void test1() {
		Manage manage = manageservice.findManageByID("12345");
		logger.info(JSON.toJSONStringWithDateFormat(manage, "yyyy-MM-dd HH:mm:ss"));
	}


	@Test
	public void test2(){
		Manage manage = new Manage();
		manage.setManageId("");
		manage.setManagePass("54321");
		manageservice.insert(manage);
	}
	

}
