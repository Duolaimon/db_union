package db_union.reply.model;

import java.util.Date;

public class Reply {
    private Integer replyId;

    private String replyContent;

    private Date replyTime;

    private Short replyState;

    private String departmentId;

    private Integer adviceId;

    private String replyReason;

    private String leaderReply;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Short getReplyState() {
        return replyState;
    }

    public void setReplyState(Short replyState) {
        this.replyState = replyState;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public Integer getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public String getReplyReason() {
        return replyReason;
    }

    public void setReplyReason(String replyReason) {
        this.replyReason = replyReason == null ? null : replyReason.trim();
    }

    public String getLeaderReply() {
        return leaderReply;
    }

    public void setLeaderReply(String leaderReply) {
        this.leaderReply = leaderReply == null ? null : leaderReply.trim();
    }
}