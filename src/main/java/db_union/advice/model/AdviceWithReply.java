package db_union.advice.model;

import db_union.reply.model.Reply;
import java.util.Date;
import java.util.List;


public class AdviceWithReply {
	
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
	
    private List<Reply> reply;

	private String adviceTitle;

	private String departmentName;

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
		this.adviceNum = adviceNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAdviceContent() {
		return adviceContent;
	}

	public void setAdviceContent(String adviceContent) {
		this.adviceContent = adviceContent;
	}

	public String getAdviceDo() {
		return adviceDo;
	}

	public void setAdviceDo(String adviceDo) {
		this.adviceDo = adviceDo;
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
		this.adviceAgree = adviceAgree;
	}

	public String getAdviceName() {
		return adviceName;
	}

	public void setAdviceName(String adviceName) {
		this.adviceName = adviceName;
	}

	public String getAdviceWorkspace() {
		return adviceWorkspace;
	}

	public void setAdviceWorkspace(String adviceWorkspace) {
		this.adviceWorkspace = adviceWorkspace;
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
		this.contactway = contactway;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public List<Reply> getReply() {
		return reply;
	}

	public void setReply(List<Reply> reply) {
		this.reply = reply;
	}

	public String getAdviceTitle() {
		return adviceTitle;
	}

	public void setAdviceTitle(String adviceTitle) {
		this.adviceTitle = adviceTitle == null ? null : adviceTitle.trim();
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName == null ? null : departmentName.trim();
	}
}
