package db_union.reply.service;

import db_union.reply.model.Reply;
import db_union.utils.Page;

import java.util.List;

public interface IReplyService {

	int insert(Reply reply);

	List<Reply> findReplyPass();

	public List<Reply> findReplyPassByPage(Page page);

	int countAll();

	public List<Reply> selectByAdviceID(Integer ADVICEID);
}
