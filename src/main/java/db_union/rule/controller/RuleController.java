package db_union.rule.controller;

import db_union.rule.model.Rule;
import db_union.rule.service.IRuleService;
import db_union.utils.Page;
import db_union.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cirno
 * on 2017/7/5.
 */
@RestController
@CrossOrigin
@RequestMapping("/rule")
public class RuleController {

    private IRuleService iRuleService;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setiRuleService(IRuleService iRuleService) {
        this.iRuleService = iRuleService;
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public Integer insertRule(Rule rule){
        return iRuleService.insertRule(rule);
    }

    @RequestMapping("/showRuleByID")
    public Rule findRuleBuId(Integer id){
        return iRuleService.findRuleById(id);
    }

    @RequestMapping("/showRuleByPage")
    public List findRuleByPage(Integer count){
        Page page = PageUtil.createPage(10,iRuleService.countAll(),count);
        List list = iRuleService.findRuleByPage(page);
        list.add(page);
        return list;
    }
}
