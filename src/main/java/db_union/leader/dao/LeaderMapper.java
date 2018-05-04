package db_union.leader.dao;

import db_union.leader.model.Leader;

import java.util.List;

public interface LeaderMapper {

    int deleteByPrimaryKey(Integer leaderId);

    int insert(Leader record);

    int insertSelective(Leader record);

    Leader selectByPrimaryKey(Integer leaderId);

    int updateByPrimaryKeySelective(Leader record);

    int updateByPrimaryKey(Leader record);

    List<Leader> selectAllLeaderName();
}