package db_union.meeting.service;
import db_union.meeting.model.Meeting;
import db_union.utils.Page;

import java.util.List;

/**
 * Created by cirno
 * on 2017/6/19.
 */
public interface IMeetingService {

    Integer insertMeeting(Meeting meeting);

    Meeting findByMeetingId(Integer meetingId);

    Integer countAll();

    List findMeetingByPage(Page page);
}
