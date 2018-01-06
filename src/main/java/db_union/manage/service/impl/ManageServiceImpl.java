package db_union.manage.service.impl;

import db_union.manage.dao.ManageMapper;
import db_union.manage.model.Manage;
import db_union.manage.service.IManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageServiceImpl implements IManageService {

	private ManageMapper managemapper;
	
	public ManageMapper getManagemapper() {
		return managemapper;
	}

	@Autowired
	public void setManagemapper(ManageMapper managemapper) {
		this.managemapper = managemapper;
	}

	@Override
	public Manage findManageByID(String MANAGE_ID) {
		// TODO Auto-generated method stub
		return managemapper.selectByPrimaryKey(MANAGE_ID);
	}

	@Override
	public Integer insert(Manage manage) {
		return managemapper.insert(manage);
	}

}
