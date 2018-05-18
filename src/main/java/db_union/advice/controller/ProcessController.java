package db_union.advice.controller;

import db_union.advice.service.IProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/processController")
public class ProcessController {

	private IProcessService processservice;

	@Autowired
	public void setProcessservice(IProcessService processservice) {
		this.processservice = processservice;
	}

	@GetMapping("/")
	public String noPage() {
		return "404";
	}

	@GetMapping("/createProcess")
	public @ResponseBody
	List<Process> createProess(String USERID){
		return processservice.createProcess(USERID);
	}
}
