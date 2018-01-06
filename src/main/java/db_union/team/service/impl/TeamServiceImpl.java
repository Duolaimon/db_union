package db_union.team.service.impl;

import db_union.team.dao.TeamMapper;
import db_union.team.model.Team;
import db_union.team.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cirno
 * on 2017/10/6.
 */
@Service
public class TeamServiceImpl implements ITeamService {

    private TeamMapper teamMapper;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setTeamMapper(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }

    @Override
    public Team findTeamById(Integer id) {
        return teamMapper.selectByPrimaryKey(id);
    }
}
