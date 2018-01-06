package db_union.leader.service.impl;

import db_union.leader.dao.LeaderMapper;
import db_union.leader.model.Leader;
import db_union.leader.service.ILeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cirno
 * on 2017/6/18.
 */
@Service
public class LeaderServiceImpl implements ILeaderService {

    private LeaderMapper leaderMapper;

    @Autowired
    public void setLeaderMapper(LeaderMapper leaderMapper) {
        this.leaderMapper = leaderMapper;
    }

    @Override
    public Leader findLeaderById(Integer id) {
        return leaderMapper.selectByPrimaryKey(id);
    }
}
