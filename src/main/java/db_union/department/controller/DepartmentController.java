package db_union.department.controller;

import java.util.HashMap;
import db_union.department.model.Department;
import db_union.department.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin
@Controller
@RequestMapping("/departmentController")
public class DepartmentController {
	
	private IDepartmentService departmentservice;

	@Autowired
	public void setDepartmentservice(IDepartmentService departmentservice) {
		this.departmentservice = departmentservice;
	}

	@GetMapping("/")
	public String noPage() {
		return "404";
	}

	@GetMapping("/name")
	public @ResponseBody HashMap<String,String> findDepartmentName(String DEPARTMENTNAME){
		System.out.println(DEPARTMENTNAME);
		Department department = departmentservice.findDepartmentByID(DEPARTMENTNAME);
		String name = null;
		HashMap<String,String> map = new HashMap<String,String>();
		if(department == null){
			System.out.println("department:0");
		}else{
			 name = department.getDepartmentName();
			 map.put("name", name);
		}
		return map;
	} 
	
	@GetMapping("/login")
	public @ResponseBody HashMap<String,Integer> login(String DEPATMENTID,String PASSWORD){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		Department department = departmentservice.findDepartmentByID(DEPATMENTID
);
		if(department == null){
			System.out.println("committee:null");
			map.put("FLAG", 0);
		}else{
			if(department.getDepartmentPassword().equals(PASSWORD)){
				map.put("FLAG", 1);
			}else{
				map.put("FLAG",-1);
			}
		}
		return map;
	}
}
