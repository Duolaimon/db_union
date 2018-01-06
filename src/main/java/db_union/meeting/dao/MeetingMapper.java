package db_union.meeting.dao;

import db_union.meeting.model.Meeting;
import db_union.utils.Page;

import java.util.List;

public interface MeetingMapper {
    int deleteByPrimaryKey(Integer meetingId);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(Integer meetingId);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);

    int countAll();

    List findMeetingByPage(Page page);
}