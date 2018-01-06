package db_union.rule.model;

import java.util.Date;

public class Rule {
    private Integer ruleId;

    private String ruleName;

    private String ruleContent;

    private Date ruleTime;

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public String getRuleContent() {
        return ruleContent;
    }

    public void setRuleContent(String ruleContent) {
        this.ruleContent = ruleContent == null ? null : ruleContent.trim();
    }

    public Date getRuleTime() {
        return ruleTime;
    }

    public void setRuleTime(Date ruleTime) {
        this.ruleTime = ruleTime;
    }
}