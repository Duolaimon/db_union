package db_union.organization.dao;

import db_union.organization.model.Organization;
import db_union.utils.Page;

import java.util.List;

public interface OrganizationMapper {

    int deleteByPrimaryKey(Integer organizationId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer organizationId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    Integer countAll();

    List findOrganizationByPage(Page page);
}