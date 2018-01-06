package db_union.department.service;

import db_union.department.model.Department;
import db_union.utils.Page;

import java.util.List;

public interface IDepartmentService {


	public boolean insertDepartment(Department department);

	public boolean deleteDepartment(String DEPARTMENT_ID);

	public Department findDepartmentByID(String DEPARTMENT_ID);

	public Integer countAllDepartment();

	public List<Department> findDepartmentByPage(Page page);
}
