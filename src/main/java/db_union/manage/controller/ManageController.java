package db_union.manage.controller;

import java.util.HashMap;
import db_union.manage.model.Manage;
import db_union.manage.service.IManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("/manageController")
public class ManageController {
	
	private IManageService manageservice;

	@Autowired
	public void setManageservice(IManageService manageservice) {
		this.manageservice = manageservice;
	}

	@GetMapping("/")
	public String noPage() {
		return "404";
	}

	@PostMapping("/insertManage")
	public @ResponseBody Integer insert(Manage manage){
		return manageservice.insert(manage);
	}

	@GetMapping("/login")
	public @ResponseBody HashMap<String,Integer> login(String manageid,String password){
		HashMap<String,Integer> info  = new HashMap<String,Integer>();
		Manage manage = manageservice.findManageByID(manageid);
		if(manage == null){

			info.put("info", 0);
		}else{
			if(password.equals(manage.getManagePass())){

				info.put("info", 1);
			}else{

				info.put("info", -1);
			}
		}
		return info;
	}
}