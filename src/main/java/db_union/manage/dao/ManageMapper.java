package db_union.manage.dao;


import db_union.manage.model.Manage;

public interface ManageMapper {

    int deleteByPrimaryKey(String manageId);

    int insert(Manage record);

    int insertSelective(Manage record);

    Manage selectByPrimaryKey(String manageId);

    int updateByPrimaryKeySelective(Manage record);

    int updateByPrimaryKey(Manage record);
}