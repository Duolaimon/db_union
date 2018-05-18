package db_union.committee.controller;

import java.util.HashMap;

import db_union.committee.model.Committee;
import db_union.committee.service.ICommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping("/committeeController")
public class CommitteeController {
	
	private ICommitteeService committeeservice;
	
	public ICommitteeService getCommitteeservice() {
		return committeeservice;
	}
	@Autowired
	public void setCommitteeservice(ICommitteeService committeeservice) {
		this.committeeservice = committeeservice;
	}

	@GetMapping("/")
	public String noPage() {
		return "404";
	}


	@GetMapping("/name")
	public @ResponseBody HashMap<String,String> findCommitteeName(String COMMITTEE_ID){
		System.out.println(COMMITTEE_ID);
		Committee committee = committeeservice.findCommitteeByID(COMMITTEE_ID);
		String name = null;
		HashMap<String,String> map = new HashMap<String,String>();
		if(committee == null){
			System.out.println("committee:0");
		}else{
			 name = committee.getCommitteeName();
			 map.put("name", name);
		}
		return map;
	} 
	
	@GetMapping("/login")
	public @ResponseBody HashMap<String,Integer> login(String COMMITTEEID,String PASSWORD){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		Committee committee = committeeservice.findCommitteeByID(COMMITTEEID);
		if(committee == null){
			System.out.println("committee:null");
			map.put("FLAG", 0);
		}else{
			if(committee.getCommitteePass().equals(PASSWORD)){
				map.put("FLAG", 1);
			}else{
				map.put("FLAG",-1);
			}
		}
		return map;
	}
}
