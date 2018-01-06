package test;

import db_union.event.model.Event;
import db_union.event.service.IEventService;
import db_union.utils.Page;
import db_union.utils.PageUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestEvent {

    private static final Logger logger = Logger.getLogger(TestManage.class);

    private IEventService iEventService;
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setiEventService(IEventService iEventService) {
        this.iEventService = iEventService;
    }

    @Test
    public void test1() throws UnsupportedEncodingException {
        Event event = new Event();
        event.setEventContent("lihou");
        event.setEventTitle("测试");
        for(int i=0;i<50;i++){
            iEventService.insertEvent(event);
        }
    }

    @Test
    public void test2() {
        Event event = iEventService.findByEventId(25);
        logger.info(JSON.toJSONStringWithDateFormat(event, "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test3(){
        Page page = PageUtil.createPage(10,iEventService.countAll(),1);
        List list = iEventService.findEventByPage(page);
        logger.info(JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd HH:mm:ss"));
    }
}
