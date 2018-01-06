package db_union.manage.service;


import db_union.manage.model.Manage;

public interface IManageService {

	Manage findManageByID(String MANAGE_ID);

	Integer insert(Manage manage);
}
