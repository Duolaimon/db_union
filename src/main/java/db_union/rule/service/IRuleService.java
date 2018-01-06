package db_union.rule.service;

import db_union.rule.model.Rule;
import db_union.utils.Page;

import java.util.List;

/**
 * Created by cirno
 * on 2017/7/5.
 */
public interface IRuleService {

    Integer insertRule(Rule rule);

    Rule findRuleById(Integer id);

    Integer countAll();

    List findRuleByPage(Page page);
}
