package db_union.organization.service.impl;

import db_union.organization.dao.OrganizationMapper;
import db_union.organization.model.Organization;
import db_union.organization.service.IOrganizationService;
import db_union.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cirno
 * on 2017/7/5.
 */

@Service
public class OrganizationServiceImpl implements IOrganizationService {

    private OrganizationMapper organizationMapper;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setOrganizationMapper(OrganizationMapper organizationMapper) {
        this.organizationMapper = organizationMapper;
    }

    @Override
    public Integer insertOrganization(Organization organization) {
        return organizationMapper.insert(organization);
    }

    @Override
    public Organization findOrganization(Integer id) {
        return organizationMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer countAll() {
        return organizationMapper.countAll();
    }

    @Override
    public List findOrganizationByPage(Page page) {
        return organizationMapper.findOrganizationByPage(page);
    }
}
