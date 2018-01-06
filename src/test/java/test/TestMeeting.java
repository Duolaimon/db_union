package test;

import java.util.List;

import db_union.meeting.model.Meeting;
import db_union.meeting.service.IMeetingService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import db_union.utils.Page;
import db_union.utils.PageUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMeeting {
    private static final Logger logger = Logger.getLogger(TestNews.class);
    //logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));

    private IMeetingService iMeetingService;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setiMeetingService(IMeetingService iMeetingService) {
        this.iMeetingService = iMeetingService;
    }

    @Test
    public void test_insert(){
        Meeting meeting = new Meeting();
        meeting.setMeetingContent("ceshi");
        meeting.setMeetingTitle("ceshi");
        for(int i=0;i<50;i++){
            iMeetingService.insertMeeting(meeting);
        }
    }

    @Test
    public void test_all(){
        int count = iMeetingService.countAll();
        logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test_findByPage(){
        Page page = PageUtil.createPage(10, iMeetingService.countAll(), 1);
        List<Object> list = iMeetingService.findMeetingByPage(page);
        logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
    }
}
