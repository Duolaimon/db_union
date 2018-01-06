package db_union.organization.service;

import db_union.organization.model.Organization;
import db_union.utils.Page;

import java.util.List;

/**
 * Created by cirno
 * on 2017/7/5.
 */
public interface IOrganizationService {

    Integer insertOrganization(Organization organization);

    Organization findOrganization(Integer id);

    Integer countAll();

    List findOrganizationByPage(Page page);
}
