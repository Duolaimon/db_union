package db_union.advice.controller;

import java.util.HashMap;

import db_union.advice.service.IAdvicePassService;
import db_union.advice.service.IAdviceService;
import db_union.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping("/indexController")
public class indexController {
	
	private INewsService newsservice;

	@Autowired
	public void setNewsservice(INewsService newsservice) {
		this.newsservice = newsservice;
	}
	
	private IAdviceService adviceservice;

	@Autowired
	public void setAdviceservice(IAdviceService adviceservice) {
		this.adviceservice = adviceservice;
	}
	
	private IAdvicePassService advicepassservice;

	@Autowired
	public void setAdvicepassservice(IAdvicePassService advicepassservice) {
		this.advicepassservice = advicepassservice;
	}
	
	@RequestMapping("/showIndex")
	public @ResponseBody HashMap<String,Object> showIndex(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("advicepass", advicepassservice.findPassAdvice());
		map.put("advice", adviceservice.findAdviceIndex());
		map.put("news", newsservice.findNews_index());
		return map;
	}
}
