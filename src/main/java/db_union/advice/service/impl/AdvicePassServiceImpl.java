package db_union.advice.service.impl;

import db_union.advice.dao.AdviceMapper;
import db_union.advice.model.Advice;
import db_union.advice.service.IAdvicePassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import db_union.utils.Page;

import java.util.List;


@Service
public class AdvicePassServiceImpl implements IAdvicePassService {

	private AdviceMapper advicemapper;

	@Autowired
	public void setAdvicemapper(AdviceMapper advicemapper) {
		this.advicemapper = advicemapper;
	}

	@Override
	public List<Advice> findPassAdviceByPage(Page page) {
		// TODO Auto-generated method stub
		return advicemapper.selectAllPassAdvice(page);
	}

	@Override
	public List<Advice> findPassAdvice() {
		// TODO Auto-generated method stub
		return advicemapper.findAdvicePass();
	}	
}