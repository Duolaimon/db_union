package db_union.leader.service;

import db_union.leader.model.Leader;

import java.util.List;

/**
 * Created by cirno
 * on 2017/6/18.
 */
public interface ILeaderService {

    Leader findLeaderById(Integer id);

    List<Leader> findLeaderNameList();
}
