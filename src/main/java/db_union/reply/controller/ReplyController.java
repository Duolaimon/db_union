package db_union.reply.controller;

import db_union.advice.model.Advice;
import db_union.advice.service.IAdviceService;
import db_union.reply.model.Reply;
import db_union.reply.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/replyController")
public class ReplyController {

	private IReplyService replyservice;

	@Autowired
	public void setReplyservice(IReplyService replyservice) {
		this.replyservice = replyservice;
	}

	private IAdviceService adviceservice;

	@Autowired
	public void setAdviceservice(IAdviceService adviceservice) {
		this.adviceservice = adviceservice;
	}
	@GetMapping("/")
	public String noPage() {
		return "404";
	}
	@RequestMapping(value = "/insertReply",method = RequestMethod.POST)
	public Integer insertReply(Reply reply){
		System.out.println(reply.getAdviceId());
		Advice advice = adviceservice.findAdviceByID(reply.getAdviceId());
		advice.setAdviceState(1);
		adviceservice.updateByPrimaryKeySelective(advice);
		int count = replyservice.insert(reply);
		System.out.println(reply.getLeaderReply());
		return count;
	}
}