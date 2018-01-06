package db_union.reply.dao;

import db_union.reply.model.Reply;
import db_union.utils.Page;

import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer replyId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    List<Reply> findReplyPass();

    List<Reply> findReplyPassByPage(Page page);

    int countAll();

    List<Reply> selectByAdviceID(Integer ADVICEID);
}