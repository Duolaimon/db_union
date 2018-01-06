package db_union.advice.service.impl;

import db_union.advice.dao.AdviceMapper;
import db_union.advice.model.Advice;
import db_union.advice.service.IAdviceWithReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdviceWithReplyImpl implements IAdviceWithReplyService {
	
	private AdviceMapper advicemapper;
	@Autowired
	public void setAdvicemapper(AdviceMapper advicemapper) {
		this.advicemapper = advicemapper;
	}

	@Override
	public Advice findAdviceWithReplyByPage() {
		// TODO Auto-generated method stub
		return null;
	}


}
