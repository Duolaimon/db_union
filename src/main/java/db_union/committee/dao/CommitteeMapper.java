package db_union.committee.dao;

import db_union.committee.model.Committee;
import db_union.utils.Page;

import java.util.List;

public interface CommitteeMapper {
    int deleteByPrimaryKey(String committeeId);

    int insert(Committee record);

    int insertSelective(Committee record);

    Committee selectByPrimaryKey(String committeeId);

    int updateByPrimaryKeySelective(Committee record);

    int updateByPrimaryKey(Committee record);

    //
    int countAllCommittee();

    //
    List<Committee> selectByPage(Page page);
}