package db_union.organization.model;

import java.util.Date;

public class Organization {
    private Integer organizationId;

    private String eorganizationName;

    private String organizationContent;

    private Date organizationTime;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getEorganizationName() {
        return eorganizationName;
    }

    public void setEorganizationName(String eorganizationName) {
        this.eorganizationName = eorganizationName == null ? null : eorganizationName.trim();
    }

    public String getOrganizationContent() {
        return organizationContent;
    }

    public void setOrganizationContent(String organizationContent) {
        this.organizationContent = organizationContent == null ? null : organizationContent.trim();
    }

    public Date getOrganizationTime() {
        return organizationTime;
    }

    public void setOrganizationTime(Date organizationTime) {
        this.organizationTime = organizationTime;
    }
}