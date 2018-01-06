package db_union.meeting.controller;

import db_union.meeting.model.Meeting;
import db_union.meeting.service.IMeetingService;
import db_union.utils.Page;
import db_union.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cirno
 * on 2017/6/19.
 */
@CrossOrigin
@RestController
@RequestMapping("/meeting")
public class MeetingController {

    private IMeetingService iMeetingService;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setiMeetingService(IMeetingService iMeetingService) {
        this.iMeetingService = iMeetingService;
    }

    @RequestMapping(value = "/insertMeeting",method = RequestMethod.POST)
    public Integer insertMeeting(Meeting meeting){
        return iMeetingService.insertMeeting(meeting);
    }

    @RequestMapping("/showMeeting")
    public Meeting showMeeting(Integer id){
        return iMeetingService.findByMeetingId(id);
    }

    @RequestMapping("/showMeetingByPage")
    public List showMeetingByPage(Integer count){
        Page page = PageUtil.createPage(10,iMeetingService.countAll(),count);
        List list = iMeetingService.findMeetingByPage(page);
        list.add(page);
        return list;
    }
}