package db_union.reply.service.impl;

import db_union.reply.dao.ReplyMapper;
import db_union.reply.model.Reply;
import db_union.reply.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import db_union.utils.Page;

import java.util.List;

@Service
public class ReplyServiceImpl implements IReplyService {

	private ReplyMapper replymapper;

	@Autowired
	public void setReplymapper(ReplyMapper replymapper) {
		this.replymapper = replymapper;
	}
	
	@Override
	public List<Reply> findReplyPass() {
		// TODO Auto-generated method stub
		return replymapper.findReplyPass();
	}

	@Override
	public List<Reply> findReplyPassByPage(Page page) {
		// TODO Auto-generated method stub
		return replymapper.findReplyPassByPage(page);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return replymapper.countAll();
	}

	@Override
	public List<Reply> selectByAdviceID(Integer ADVICEID) {
		// TODO Auto-generated method stub
		return replymapper.selectByAdviceID(ADVICEID);
	}

	@Override
	public int insert(Reply reply) {
		// TODO Auto-generated method stub
		return replymapper.insert(reply);
	}

}
