package db_union.department.dao;

import java.util.List;

import db_union.department.model.Department;
import db_union.utils.Page;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    //
    int countAllDepartment();
    
    //
    List<Department> selectByPage(Page page);
}