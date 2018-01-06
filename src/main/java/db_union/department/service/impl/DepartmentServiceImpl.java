package db_union.department.service.impl;

import db_union.department.dao.DepartmentMapper;
import db_union.department.model.Department;
import db_union.department.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import db_union.utils.Page;
import java.util.List;

@Service("depaermentservice")
public class DepartmentServiceImpl implements IDepartmentService {

	private DepartmentMapper departmentmapper;

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	public void setDepartmentmapper(DepartmentMapper departmentmapper) {
		this.departmentmapper = departmentmapper;
	}

	@Override
	public boolean insertDepartment(Department department) {
		// TODO Auto-generated method stub
		int count =  departmentmapper.insert(department);
		return (count>0)?true:false;
	}

	@Override
	public boolean deleteDepartment(String DEPARTMENT_ID) {
		// TODO Auto-generated method stub
		int count = departmentmapper.deleteByPrimaryKey(DEPARTMENT_ID);
		return (count>0)?true:false;
	}

	@Override
	public Department findDepartmentByID(String DEPARTMENT_ID) {
		// TODO Auto-generated method stub
		return departmentmapper.selectByPrimaryKey(DEPARTMENT_ID);
	}
	
	@Override
	public Integer countAllDepartment() {
		// TODO Auto-generated method stub
		return departmentmapper.countAllDepartment();
	}

	@Override
	public List<Department> findDepartmentByPage(Page page) {
		// TODO Auto-generated method stub
		return departmentmapper.selectByPage(page);
	}
}
