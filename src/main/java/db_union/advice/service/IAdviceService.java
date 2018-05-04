package db_union.advice.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db_union.advice.model.Advice;
import db_union.utils.Page;

public interface IAdviceService {

	List<Advice> getAdvicesByLeader(Map map);

	boolean insertAdviceLeader(Integer adviceId, Integer leaderId);

	public boolean insertAdvice(Advice advice);

	public boolean deleteAdvice(Integer ADVICE_ID);

	public Advice findAdviceByID(Integer ADVICE_ID);

	public Integer countAllAdvice();

	public List<Advice> findAdviceByPage(Page page);

	public int findCountByID(Integer ADVICE_ID);

	public boolean updateCountByPrimaryKeySelective(Advice advice);

	public boolean updateAdvicestate(Advice advice);

	public List<Advice> findAdviceByUserID(String USER_ID);

	public List<Advice> findAdviceIndex();

	public List<Object> selectPoiAdviceByPage(Page page);

	public Integer adviceCount(Integer ADVICEID, Integer COUNT);

	public Integer countAllPoiAdvice();

	List<Object> findAdviceByCommitteeID(HashMap<String, Object> hashmap);

	List<Object> findAdviceByDepartmentID(HashMap<String, Object> hashmap);

	List<Advice> selectAdviceLike(HashMap<String, Object> map);
	
	int updateByPrimaryKeySelective(Advice advice);
	
	int countAllPassAdvice();
	
	int countAllPassAdviceLike(String poi);
	
	int countAllCountB2();
	
	int countAllAdviceByDEPARTMENTID(String DEAPRTMENTID);
	
	int countAllAdviceByCOMMITTEEID(String COMMITTEEID);

	int countAllAdviceByLeaderId(Integer leaderId);

	int countState6ByDmid(String dmid);
	
	Advice selectAdviceN0N2(Integer id);
	
	List<Advice> selectCountB2(Page page);
	
	List<Advice> selectAllPassAdvice(Page page);
	
	Integer countAllState(Integer stateid);
	
	Integer findCountByMonth(String date);
	
	List findAdviceByStateF1(Page page);

	List<Object> select6ByDmid(HashMap<String, Object> map);

	List<Object> selectAllState(HashMap<String,Object> map);
}
