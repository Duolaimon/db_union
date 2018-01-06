package test;

import db_union.committee.model.Committee;
import db_union.committee.service.ICommitteeService;
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

public class TestCommit {
	private static final Logger logger = Logger.getLogger(TestManage.class);

	private ICommitteeService committeeservice;
	
	
	public ICommitteeService getCommitteeservice() {
		return committeeservice;
	}

	@Autowired
	public void setCommitteeservice(ICommitteeService committeeservice) {
		this.committeeservice = committeeservice;
	}


	@Test
	public void test_insert(){
		Committee c = new Committee();
		c.setCommitteeId("3");
		c.setCommitteeName("test");
		c.setCommitteePass("test");
		committeeservice.insertCommittee(c);
	}
	
	@Test
	public void test_delete(){
		boolean flag = committeeservice.deleteCommitteeByID("3");
		logger.info(JSON.toJSONStringWithDateFormat(flag, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test_all(){
		int count = committeeservice.allCountCommittee();
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test_find(){
		Page page = PageUtil.createPage(2, committeeservice.allCountCommittee(), 1);
		List<Committee> list = committeeservice.findCommitteeByPage(page);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	
}