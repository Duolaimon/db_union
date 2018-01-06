package db_union.leader.service;

import db_union.leader.model.Leader;

/**
 * Created by cirno
 * on 2017/6/18.
 */
public interface ILeaderService {

    Leader findLeaderById(Integer id);
}
