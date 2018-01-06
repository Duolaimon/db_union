package db_union.advice.model;

import java.util.Date;

public class Process {
	
	private Integer adviceId;
	private String committeeName;
	private String departmentName;
	private String adviceContent;
	private String title;
	private Date adviceTime;
	private Integer adviceState;
	
	public Integer getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(Integer adviceId) {
		this.adviceId = adviceId;
	}
	public String getCommitteeName() {
		return committeeName;
	}
	public void setCommitteeName(String committeeName) {
		this.committeeName = committeeName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getAdviceContent() {
		return adviceContent;
	}
	public void setAdviceContent(String adviceContent) {
		this.adviceContent = adviceContent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getAdviceTime() {
		return adviceTime;
	}
	public void setAdviceTime(Date adviceTime) {
		this.adviceTime = adviceTime;
	}
	public Integer getAdviceState() {
		return adviceState;
	}
	public void setAdviceState(Integer adviceState) {
		this.adviceState = adviceState;
	}
}
