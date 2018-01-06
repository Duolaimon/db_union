package db_union.rule.dao;

import db_union.rule.model.Rule;
import db_union.utils.Page;

import java.util.List;

public interface RuleMapper {
    int deleteByPrimaryKey(Integer ruleId);

    int insert(Rule record);

    int insertSelective(Rule record);

    Rule selectByPrimaryKey(Integer ruleId);

    int updateByPrimaryKeySelective(Rule record);

    int updateByPrimaryKey(Rule record);

    int countAll();

    List findRuleByPage(Page page);
}