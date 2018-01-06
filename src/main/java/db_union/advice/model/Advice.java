package db_union.advice.model;

import java.util.Date;

public class Advice {
    private Integer adviceId;

    private String adviceNum;

    private String title;

    private String adviceContent;

    private String adviceDo;

    private Integer adviceState;

    private Integer count;

    private String adviceAgree;

    private String adviceName;

    private String adviceWorkspace;

    private Date adviceTime;

    private String contactway;

    private String userId;

    private String departmentId;

    private String adviceTitle;

    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public String getAdviceNum() {
        return adviceNum;
    }

    public void setAdviceNum(String adviceNum) {
        this.adviceNum = adviceNum == null ? null : adviceNum.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAdviceContent() {
        return adviceContent;
    }

    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent == null ? null : adviceContent.trim();
    }

    public String getAdviceDo() {
        return adviceDo;
    }

    public void setAdviceDo(String adviceDo) {
        this.adviceDo = adviceDo == null ? null : adviceDo.trim();
    }

    public Integer getAdviceState() {
        return adviceState;
    }

    public void setAdviceState(Integer adviceState) {
        this.adviceState = adviceState;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getAdviceAgree() {
        return adviceAgree;
    }

    public void setAdviceAgree(String adviceAgree) {
        this.adviceAgree = adviceAgree == null ? null : adviceAgree.trim();
    }

    public String getAdviceName() {
        return adviceName;
    }

    public void setAdviceName(String adviceName) {
        this.adviceName = adviceName == null ? null : adviceName.trim();
    }

    public String getAdviceWorkspace() {
        return adviceWorkspace;
    }

    public void setAdviceWorkspace(String adviceWorkspace) {
        this.adviceWorkspace = adviceWorkspace == null ? null : adviceWorkspace.trim();
    }

    public Date getAdviceTime() {
        return adviceTime;
    }

    public void setAdviceTime(Date adviceTime) {
        this.adviceTime = adviceTime;
    }

    public String getContactway() {
        return contactway;
    }

    public void setContactway(String contactway) {
        this.contactway = contactway == null ? null : contactway.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getAdviceTitle() {
        return adviceTitle;
    }

    public void setAdviceTitle(String adviceTitle) {
        this.adviceTitle = adviceTitle == null ? null : adviceTitle.trim();
    }
}