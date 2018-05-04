package test;

import db_union.leader.dao.LeaderMapper;
import db_union.leader.service.ILeaderService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestLeader{
    private static final Logger logger = Logger.getLogger(TestManage.class);
    private ILeaderService leaderService;
    private LeaderMapper leaderMapper;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setLeaderService(ILeaderService leaderService, LeaderMapper leaderMapper) {
        this.leaderService = leaderService;
        this.leaderMapper = leaderMapper;
    }

    @Test
    public void test1(){
        leaderService.findLeaderById(20145425);
    }

    @Test
    public void findLeaderNameList() {
        System.out.println(leaderMapper.selectAllLeaderName());
        System.out.println(leaderMapper.selectByPrimaryKey(32131));
    }
}