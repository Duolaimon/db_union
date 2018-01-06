package db_union.event.service;

import db_union.event.model.Event;
import db_union.utils.Page;

import java.util.List;

/**
 * Created by cirno
 * on 2017/6/19.
 */
public interface IEventService {

    Integer insertEvent(Event event);

    Event findByEventId(Integer id);

    Integer countAll();

    List findEventByPage(Page page);
}
