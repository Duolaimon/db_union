package test;

import db_union.department.model.Department;
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

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestDepartment {

	private static final Logger logger = Logger.getLogger(TestManage.class);
	
	private IDepartmentService departmentservice;
		
	public IDepartmentService getDepartmentservice() {
		return departmentservice;
	}

	@Autowired
	public void setDepartmentservice(IDepartmentService departmentservice) {
		this.departmentservice = departmentservice;
	}

	@Test
	public void test_insert(){
		Department d = new Department();
		d.setDepartmentId("3");
		d.setDepartmentName("test");
		d.setDepartmentPassword("test");
		departmentservice.insertDepartment(d);
	}
	
	@Test
	public void test_delete(){
		departmentservice.deleteDepartment("3");
	}
	
	@Test
	public void test_all(){
		int count = departmentservice.countAllDepartment();
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test_find(){
		Page page = PageUtil.createPage(2, departmentservice.countAllDepartment(), 1);
		List<Department> list = departmentservice.findDepartmentByPage(page);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
}
