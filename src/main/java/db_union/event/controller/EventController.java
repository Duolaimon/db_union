package db_union.event.controller;

import db_union.event.model.Event;
import db_union.event.service.IEventService;
import db_union.utils.Page;
import db_union.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cirno
 * on 2017/6/19.
 */
@CrossOrigin
@RestController
@RequestMapping("/event")
public class EventController {

    private IEventService iEventService;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setiEventService(IEventService iEventService) {
        this.iEventService = iEventService;
    }

    @GetMapping("/")
    public String noPage() {
        return "404";
    }

    @RequestMapping(value = "/insertEvent",method = RequestMethod.POST)
    public Integer insertEvent(Event event){
        return iEventService.insertEvent(event);
    }

    @GetMapping("/showEvent")
    public Event showEvent(Integer id){
        return iEventService.findByEventId(id);
    }

    @GetMapping("/showEventByPage")
    public List showEventByPage(Integer count){
        Page page = PageUtil.createPage(10,iEventService.countAll(),count);
        List list = iEventService.findEventByPage(page);
        list.add(page);
        return list;
    }
}