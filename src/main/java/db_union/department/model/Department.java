package db_union.department.model;

public class Department {
    private String departmentId;

    private String departmentPassword;

    private String departmentName;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentPassword() {
        return departmentPassword;
    }

    public void setDepartmentPassword(String departmentPassword) {
        this.departmentPassword = departmentPassword == null ? null : departmentPassword.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }
}