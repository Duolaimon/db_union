package test;

import db_union.reply.model.Reply;
import db_union.reply.service.IReplyService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import db_union.utils.PageUtil;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestReply {
	private static final Logger logger = Logger.getLogger(TestManage.class);
	//logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	private IReplyService replyservice;

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	public void setReplyservice(IReplyService replyservice) {
		this.replyservice = replyservice;
	}
	
	@Test
	public void test_insert(){
		Reply reply = new Reply();
		reply.setAdviceId(1);
		reply.setReplyContent("你好");
		reply.setReplyReason("你猜");
		reply.setLeaderReply("领导回复");
		replyservice.insert(reply);
	}
	@Test
	public void test_delete(){
		
	}
	@Test
	public void test_all(){
		replyservice.countAll();
	}
	@Test
	public void test_find(){
		List<Reply> list = replyservice.findReplyPass();
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_findByPage(){
		PageUtil.createPage(2, replyservice.countAll(), 1);
		List<Reply> list = replyservice.findReplyPass();
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	@Test
	public void test_find3(){
		List<Reply> list = replyservice.selectByAdviceID(25);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
}