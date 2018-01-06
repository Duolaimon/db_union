package test;

import java.util.HashMap;
import java.util.List;

import db_union.advice.model.Advice;
import db_union.advice.service.IAdviceService;
import db_union.committee.service.ICommitteeService;
import db_union.department.service.IDepartmentService;
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
public class TestAdvice {
	private static final Logger logger = Logger.getLogger(TestManage.class);
	
	private IAdviceService adviceservice;

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	public void setAdviceservice(IAdviceService adviceservice) {
		this.adviceservice = adviceservice;
	}
	
	private ICommitteeService committeeservice;

	@Autowired
	public void setCommitteeservice(ICommitteeService committeeservice) {
		this.committeeservice = committeeservice;
	}
	
	private IDepartmentService department;

	@Autowired
	public void setDepartment(IDepartmentService department) {
		this.department = department;
	}

	@Test
	public void test_insert(){
		Advice a = new Advice();
		for(int i=0;i<100;i++){
			a.setAdviceNum("123456");
			a.setUserId("test");
			adviceservice.insertAdvice(a);
		}
	}
	@Test
	public void test_delete(){
		boolean flag = adviceservice.deleteAdvice(201);
		logger.info(JSON.toJSONStringWithDateFormat(flag, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_all(){
		int count = adviceservice.countAllAdvice();
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find(){
		Page page = PageUtil.createPage(2, adviceservice.countAllAdvice(), 1);
		List<Advice> list = adviceservice.findAdviceByPage(page);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find2(){
		List<Advice> list = adviceservice.findAdviceIndex();
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find3(){
		Page page = PageUtil.createPage(2, adviceservice.countAllAdvice(), 1);
		List<Object> list = adviceservice.selectPoiAdviceByPage(page);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find4(){
		int count = adviceservice.adviceCount(102,5);
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find5(){
		int count = adviceservice.countAllPoiAdvice();
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find6(){
		Page page = PageUtil.createPage(2, adviceservice.countAllAdvice(), 1);
		HashMap<String,Object> hashmap = new HashMap<String,Object>();
		hashmap.put("id", "test");
		hashmap.put("begin", page.getBeginIndex());
		hashmap.put("every", page.getEveryPage());
		List<Object> list = adviceservice.findAdviceByCommitteeID(hashmap);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test_find7(){
		Page page = PageUtil.createPage(2, adviceservice.countAllAdvice(), 1);
			HashMap<String,Object> hashmap = new HashMap<String,Object>();
			hashmap.put("id", "1");
			hashmap.put("begin", page.getBeginIndex());
			hashmap.put("every", page.getEveryPage());
			List<Object> list = adviceservice.findAdviceByDepartmentID(hashmap);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find8(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		Page page = PageUtil.createPage(2, adviceservice.countAllPassAdvice(), 2);
		map.put("poi", "t");
		map.put("begin", page.getBeginIndex());
		map.put("every", page.getEveryPage());
		List list = adviceservice.selectAdviceLike(map);
		list.add(page);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find9(){
		Advice advice = adviceservice.findAdviceByID(25);
		advice.setAdviceState(1);
		int count = adviceservice.updateByPrimaryKeySelective(advice);
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test_find10(){
		int count = adviceservice.countAllPassAdvice();
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test_find11(){
		int count = adviceservice.countAllPassAdviceLike("t");
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test_find12(){
		Page page = PageUtil.createPage(2, adviceservice.countAllCountB2(), 1);
		List<Advice> list = adviceservice.selectCountB2(page);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find13(){
		int count = adviceservice.countAllCountB2();
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find14(){
		int count = adviceservice.countAllAdviceByDEPARTMENTID("");
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find15(){
		int count = adviceservice.countAllAdviceByCOMMITTEEID("test");
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find16(){
		Page page = PageUtil.createPage(10, adviceservice.countAllCountB2(), 1);
		List<Advice> list = adviceservice.selectCountB2(page);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find17(){
		int count = adviceservice.countAllState(2);
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find18(){
		Integer count = adviceservice.findCountByMonth("2017-03-23");
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test_find19(){
		List<Advice> list = adviceservice.findAdviceIndex();
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test_find20(){
		Page page = PageUtil.createPage(2, adviceservice.countAllState(-1), 1);
		List<Advice> list = adviceservice.findAdviceByStateF1(page);
		System.out.println(adviceservice.countAllState(-1));
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test_select(){
		Page page = PageUtil.createPage(10,adviceservice.countState6ByDmid(2+""),1);
		HashMap map = new HashMap<String,Object>();
		map.put("id",2);
		map.put("begin",page.getBeginIndex());
		map.put("every",page.getEveryPage());
		List list = adviceservice.select6ByDmid(map);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test_select2(){
		Page page = PageUtil.createPage(10,adviceservice.countAllState(6),1);
		HashMap map = new HashMap<String,Object>();
		map.put("id",6);
		map.put("begin",page.getBeginIndex());
		map.put("every",page.getEveryPage());
		List list = adviceservice.selectAllState(map);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test_select3(){
		Page page = PageUtil.createPage(10,adviceservice.countAllPoiAdvice(),1);
		HashMap map = new HashMap<String,Object>();
		map.put("poi","ceshi");
		map.put("begin",page.getBeginIndex());
		map.put("every",page.getEveryPage());
		List list = adviceservice.selectAdviceLike(map);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
}