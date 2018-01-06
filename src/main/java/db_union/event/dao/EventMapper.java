package db_union.event.dao;

import db_union.event.model.Event;
import db_union.utils.Page;

import java.util.List;

public interface EventMapper {
    int deleteByPrimaryKey(Integer eventId);

    int insert(Event record);

    int insertSelective(Event record);

    Event selectByPrimaryKey(Integer eventId);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);

    int countAll();

    List findEventByPage(Page page);
}