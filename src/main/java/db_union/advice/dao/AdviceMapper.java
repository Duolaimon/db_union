package db_union.advice.dao;

import db_union.advice.model.Advice;
import db_union.utils.Page;

import java.util.HashMap;
import java.util.List;

public interface AdviceMapper {
    int deleteByPrimaryKey(Integer adviceId);

    int insert(Advice record);

    int insertSelective(Advice record);

    Advice selectByPrimaryKey(Integer adviceId);

    int updateByPrimaryKeySelective(Advice record);

    int updateByPrimaryKeyWithBLOBs(Advice record);

    int updateByPrimaryKey(Advice record);

    Integer countAllAdvice();

    Integer selectCountByPrimaryJey(Integer ADVICE_ID);

    List<Advice> selectByPage(Page page);

    List<Advice> selectByUserID(String USER_ID);

    List<Advice> findAdviceIndex();

    List<Object> selectPoiAdviceByPage(Page page);

    int countAllPoiAdvice();

    int countAllPassAdvice();

    int countAllCountB2();
    //
    int countAllPassAdviceLike(String poi);
    //
    int countAllAdviceByDEPARTMENTID(String DEAPRTMENTID);
    //
    int countAllAdviceByCOMMITTEEID(String COMMITTEEID);

    int countState6ByDmid(String dmid);

    List<Object> findAdviceByCommitteeID(HashMap<String, Object> map);

    List<Object> findAdviceByDepartmentID(HashMap<String, Object> map);

    List<Advice> selectAdviceLike(HashMap map);

    Advice selectAdviceN0N2(Integer id);

    List<Advice> selectCountB2(Page page);

    List<Advice> selectAllPassAdvice(Page page);

    List<Advice> findAdvicePass();

    List findAdviceByStateF1(Page page);

    Integer countAllState(Integer stateid);

    Integer findCountByMonth(String date);

    List<Object> select6ByDmid(HashMap<String, Object> map);

    List<Object> selectAllState(HashMap<String,Object> map);
}