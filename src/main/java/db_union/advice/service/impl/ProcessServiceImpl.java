package db_union.advice.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import db_union.advice.dao.AdviceMapper;
import db_union.advice.model.Advice;
import db_union.advice.model.Process;
import db_union.advice.service.IProcessService;
import db_union.committee.dao.CommitteeMapper;
import db_union.department.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("processservice")
public class ProcessServiceImpl implements IProcessService {

	private AdviceMapper advicemapper;

	@Autowired
	public void setAdvicemapper(AdviceMapper advicemapper) {
		this.advicemapper = advicemapper;
	}
	
	private DepartmentMapper departmentmapper;

	@Autowired
	public void setDepartmentmapper(DepartmentMapper departmentmapper) {
		this.departmentmapper = departmentmapper;
	}

	private CommitteeMapper committeemapper;

	@Autowired
	public void setCommitteemapper(CommitteeMapper committeemapper) {
		this.committeemapper = committeemapper;
	}
	
	@Override
	public List createProcess(String ADVICE_USERID) {
		// TODO Auto-generated method stub
		List<Advice> list_advice = advicemapper.selectByUserID(ADVICE_USERID);
		List<Process> list_process = new ArrayList<>();
		for (Iterator iterator = list_advice.iterator(); iterator.hasNext();) {
			Advice advice = (Advice) iterator.next();
			Process process = new Process();
			process.setAdviceId(advice.getAdviceId());
			process.setTitle(advice.getTitle());
			process.setAdviceContent(advice.getAdviceContent());
			process.setAdviceState(advice.getAdviceState());
			process.setAdviceTime(advice.getAdviceTime());
			process.setCommitteeName(committeemapper.selectByPrimaryKey(ADVICE_USERID).getCommitteeName());
			list_process.add(process);
		}
		return list_process;
	}
}