package db_union.advice.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db_union.advice.dao.AdviceLeaderMapper;
import db_union.advice.dao.AdviceMapper;
import db_union.advice.model.Advice;
import db_union.advice.service.IAdviceService;
import db_union.leader.model.Leader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import db_union.utils.Page;

@Service("adviceservice")
public class AdviceServiceImpl implements IAdviceService {

    private AdviceMapper advicemapper;
    private AdviceLeaderMapper adviceLeaderMapper;

    @Autowired
    public void setAdvicemapper(AdviceMapper advicemapper, AdviceLeaderMapper adviceLeaderMapper) {
        this.advicemapper = advicemapper;
        this.adviceLeaderMapper = adviceLeaderMapper;
    }


    /**
     * 获得指定领导的提案
     *
     * @return
     */
    public List<Advice> getAdvicesByLeader(Map map) {
        return adviceLeaderMapper.selectAdviceByLeaderId(map);
    }

    public boolean insertAdviceLeader(Integer adviceId, Integer leaderId) {
        int count = adviceLeaderMapper.insertAdviceLeader(adviceId, leaderId);
        return count > 0;
    }


    @Override
    public boolean insertAdvice(Advice advice) {
        // TODO Auto-generated method stub
        int count = advicemapper.insert(advice);
        return (count > 0) ? true : false;
    }

    @Override
    public boolean deleteAdvice(Integer ADVICE_ID) {
        // TODO Auto-generated method stub
        int count = advicemapper.deleteByPrimaryKey(ADVICE_ID);
        return (count > 0) ? true : false;
    }

    @Override
    public Advice findAdviceByID(Integer ADVICE_ID) {
        // TODO Auto-generated method stub
        return advicemapper.selectByPrimaryKey(ADVICE_ID);
    }

    @Override
    public Integer countAllAdvice() {
        // TODO Auto-generated method stub
        return advicemapper.countAllAdvice();
    }

    @Override
    public List<Advice> findAdviceByPage(Page page) {
        // TODO Auto-generated method stub
        return advicemapper.selectByPage(page);
    }

    @Override
    public int findCountByID(Integer ADVICE_ID) {
        // TODO Auto-generated method stub
        return advicemapper.selectCountByPrimaryJey(ADVICE_ID);
    }

    @Override
    public boolean updateCountByPrimaryKeySelective(Advice advice) {
        // TODO Auto-generated method stub
        int count = advicemapper.updateByPrimaryKeySelective(advice);
        return (count > 0) ? true : false;
    }

    @Override
    public boolean updateAdvicestate(Advice advice) {
        // TODO Auto-generated method stub
        int count = advicemapper.updateByPrimaryKeySelective(advice);
        return (count > 0) ? true : false;
    }

    @Override
    public List<Advice> findAdviceByUserID(String USER_ID) {
        // TODO Auto-generated method stub
        return advicemapper.selectByUserID(USER_ID);
    }

    @Override
    public List<Advice> findAdviceIndex() {
        // TODO Auto-generated method stub
        return advicemapper.findAdviceIndex();
    }

    @Override
    public List<Object> selectPoiAdviceByPage(Page page) {
        // TODO Auto-generated method stub
        return advicemapper.selectPoiAdviceByPage(page);
    }

    @Override
    public Integer adviceCount(Integer ADVICEID, Integer COUNT) {
        // TODO Auto-generated method stub
        Advice advice = advicemapper.selectByPrimaryKey(ADVICEID);
        advice.setCount(COUNT);
        int count = advicemapper.updateByPrimaryKeySelective(advice);
        if (count > 0) {
            System.out.println("����ɹ�");
        }
        if (advice.getCount() > 2) {
            advice.setAdviceState(-1);
            advicemapper.updateByPrimaryKeySelective(advice);
        }
        return COUNT;
    }

    @Override
    public Integer countAllPoiAdvice() {
        // TODO Auto-generated method stub
        return advicemapper.countAllPoiAdvice();
    }

    @Override
    public List<Object> findAdviceByCommitteeID(HashMap<String, Object> hashmap) {
        // TODO Auto-generated method stub
        List<Object> list = advicemapper.findAdviceByCommitteeID(hashmap);
        return list;
    }

    @Override
    public List<Object> findAdviceByDepartmentID(HashMap<String, Object> hashmap) {
        // TODO Auto-generated method stub
        List<Object> list = advicemapper.findAdviceByDepartmentID(hashmap);
        return list;
    }

    @Override
    public List<Advice> selectAdviceLike(HashMap map) {
        // TODO Auto-generated method stub
        return advicemapper.selectAdviceLike(map);
    }

    @Override
    public int updateByPrimaryKeySelective(Advice advice) {
        // TODO Auto-generated method stub
        return advicemapper.updateByPrimaryKey(advice);
    }

    @Override
    public int countAllPassAdvice() {
        // TODO Auto-generated method stub
        return advicemapper.countAllPassAdvice();
    }

    @Override
    public int countAllPassAdviceLike(String poi) {
        // TODO Auto-generated method stub
        return advicemapper.countAllPassAdviceLike(poi);
    }

    @Override
    public Advice selectAdviceN0N2(Integer id) {
        // TODO Auto-generated method stub
        return advicemapper.selectAdviceN0N2(id);
    }

    @Override
    public List<Advice> selectCountB2(Page page) {
        // TODO Auto-generated method stub
        return advicemapper.selectCountB2(page);
    }

    @Override
    public int countAllCountB2() {
        // TODO Auto-generated method stub
        return advicemapper.countAllCountB2();
    }

    @Override
    public int countAllAdviceByDEPARTMENTID(String DEAPRTMENTID) {
        // TODO Auto-generated method stub
        return advicemapper.countAllAdviceByDEPARTMENTID(DEAPRTMENTID);
    }

    @Override
    public int countAllAdviceByCOMMITTEEID(String COMMITTEEID) {
        // TODO Auto-generated method stub
        return advicemapper.countAllAdviceByCOMMITTEEID(COMMITTEEID);
    }

    @Override
    public int countAllAdviceByLeaderId(Integer leaderId) {
        return advicemapper.countAllAdviceByLeaderId(leaderId);
    }

    @Override
    public int countState6ByDmid(String dmid) {
        return advicemapper.countState6ByDmid(dmid);
    }

    @Override
    public List<Advice> selectAllPassAdvice(Page page) {
        // TODO Auto-generated method stub
        return advicemapper.selectAllPassAdvice(page);
    }

    @Override
    public Integer countAllState(Integer stateid) {
        // TODO Auto-generated method stub
        return advicemapper.countAllState(stateid);
    }

    @Override
    public Integer findCountByMonth(String date) {
        // TODO Auto-generated method stub
        return advicemapper.findCountByMonth(date);
    }

    @Override
    public List findAdviceByStateF1(Page page) {
        // TODO Auto-generated method stub
        return advicemapper.findAdviceByStateF1(page);
    }

    @Override
    public List<Object> select6ByDmid(HashMap<String, Object> map) {
        return advicemapper.select6ByDmid(map);
    }

    @Override
    public List<Object> selectAllState(HashMap<String, Object> map) {
        return advicemapper.selectAllState(map);
    }
}