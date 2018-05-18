package db_union.news.controller;

import java.util.List;

import db_union.news.model.News;
import db_union.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import db_union.utils.Page;
import db_union.utils.PageUtil;

@CrossOrigin
@Controller
@RequestMapping("/newsController")
public class NewsController {

	private INewsService newsservice;

	@Autowired
	public void setNewsservice(INewsService newsservice) {
		this.newsservice = newsservice;
	}

	@GetMapping("/")
	public String noPage() {
		return "404";
	}

	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public @ResponseBody Integer insert(News news){
		return newsservice.insertNews(news);
	}

	@GetMapping("/showNews")
	public @ResponseBody News showNews(Integer NEWSID)
	{
		return newsservice.findByNewsID(NEWSID);
	}

	@GetMapping("/showNewsByPage")
	public @ResponseBody List<Object> showNewsByPage(Integer COUNT){
		Page page = PageUtil.createPage(10, newsservice.countAll(), COUNT);
		List<Object> list = newsservice.findNewsByPage(page);
		list.add(page);
		return list;
	}
}
