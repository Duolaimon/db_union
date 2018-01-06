package db_union.meeting.service.impl;

import db_union.meeting.dao.MeetingMapper;
import db_union.meeting.model.Meeting;
import db_union.meeting.service.IMeetingService;
import db_union.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cirno
 * on 2017/6/19.
 */
@Service
public class MeetingServiceImpl implements IMeetingService {

    private MeetingMapper meetingMapper;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setMeetingMapper(MeetingMapper meetingMapper) {
        this.meetingMapper = meetingMapper;
    }

    @Override
    public Integer insertMeeting(Meeting meeting) {
        return meetingMapper.insert(meeting);
    }

    @Override
    public Meeting findByMeetingId(Integer meetingId) {
        return meetingMapper.selectByPrimaryKey(meetingId);
    }

    @Override
    public Integer countAll() {
        return meetingMapper.countAll();
    }

    @Override
    public List findMeetingByPage(Page page) {
        return meetingMapper.findMeetingByPage(page);
    }
}
