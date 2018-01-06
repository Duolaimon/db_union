package test;

import db_union.advice.service.IProcessService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestProcess {
	private static final Logger logger = Logger.getLogger(TestManage.class);
	//logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	private IProcessService processservice;

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	public void setProcessservice(IProcessService processservice) {
		this.processservice = processservice;
	}
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
		List<Process> list = processservice.createProcess("test");
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
}
