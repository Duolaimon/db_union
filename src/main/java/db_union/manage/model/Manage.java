package db_union.manage.model;

public class Manage {
    private String manageId;

    private String managePass;

    public String getManageId() {
        return manageId;
    }

    public void setManageId(String manageId) {
        this.manageId = manageId == null ? null : manageId.trim();
    }

    public String getManagePass() {
        return managePass;
    }

    public void setManagePass(String managePass) {
        this.managePass = managePass == null ? null : managePass.trim();
    }
}