package db_union.rule.service.impl;

import db_union.rule.dao.RuleMapper;
import db_union.rule.model.Rule;
import db_union.rule.service.IRuleService;
import db_union.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cirno
 * on 2017/7/5.
 */
@Service
public class RuleServiceImpl implements IRuleService {

    private RuleMapper ruleMapper;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setRuleMapper(RuleMapper ruleMapper) {
        this.ruleMapper = ruleMapper;
    }

    @Override
    public Integer insertRule(Rule rule)
    {
        return ruleMapper.insert(rule);
    }

    @Override
    public Rule findRuleById(Integer id)
    {
        return ruleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer countAll()
    {
        return ruleMapper.countAll();
    }

    @Override
    public List findRuleByPage(Page page) {
        return ruleMapper.findRuleByPage(page);
    }
}
