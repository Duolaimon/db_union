package db_union.event.service.impl;

import db_union.event.dao.EventMapper;
import db_union.event.model.Event;
import db_union.event.service.IEventService;
import db_union.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cirno
 * on 2017/6/19.
 */
@Service
public class EventServiceImpl implements IEventService {

    private EventMapper eventMapper;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setEventMapper(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }

    @Override
    public Integer insertEvent(Event event) {
        return eventMapper.insert(event);
    }

    @Override
    public Event findByEventId(Integer id) {
        return eventMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer countAll() {
        return eventMapper.countAll();
    }

    @Override
    public List findEventByPage(Page page) {
        return eventMapper.findEventByPage(page);
    }
}
