package db_union.committee.service.impl;

import db_union.committee.dao.CommitteeMapper;
import db_union.committee.model.Committee;
import db_union.committee.service.ICommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import db_union.utils.Page;

import java.util.List;

@Service("committeeservice")
public class CommitteeServiceImpl implements ICommitteeService {

	private CommitteeMapper committeemapper;
	
	public CommitteeMapper getCommitteemapper() {
		return committeemapper;
	}

	@Autowired
	public void setCommitteemapper(CommitteeMapper committeemapper) {
		this.committeemapper = committeemapper;
	}

	@Override
	public Committee findCommitteeByID(String COMMITTEE_ID) {
		// TODO Auto-generated method stub
		return committeemapper.selectByPrimaryKey(COMMITTEE_ID);
	}

	@Override
	public boolean deleteCommitteeByID(String COMMITTEE_ID) {
		// TODO Auto-generated method stub
		int count = committeemapper.deleteByPrimaryKey(COMMITTEE_ID);
		return (count>0)?true:false;
	}

	@Override
	public boolean insertCommittee(Committee committee) {
		// TODO Auto-generated method stub
		int count = committeemapper.insert(committee);
		return (count>0)?true:false;
	}
	
	@Override
	public Integer allCountCommittee() {
		// TODO Auto-generated method stub
		return committeemapper.countAllCommittee();
	}

	@Override
	public List<Committee> findCommitteeByPage(Page page) {
		// TODO Auto-generated method stub
		return committeemapper.selectByPage(page);
	}


}
