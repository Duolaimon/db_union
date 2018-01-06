package db_union.advice.service;

import db_union.advice.model.Advice;
import db_union.utils.Page;

import java.util.List;

public interface IAdvicePassService {

	public List<Advice> findPassAdviceByPage(Page page);

	public List<Advice> findPassAdvice();
}
