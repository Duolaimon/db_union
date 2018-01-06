package db_union.organization.controller;

import db_union.organization.model.Organization;
import db_union.organization.service.IOrganizationService;
import db_union.utils.Page;
import db_union.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cirno
 * on 2017/7/5.
 */
@CrossOrigin
@RestController
@RequestMapping("/organization")
public class OrganizationController {

    private IOrganizationService iOrganizationService;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setiOrganizationService(IOrganizationService iOrganizationService) {
        this.iOrganizationService = iOrganizationService;
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Integer insertOrganization(Organization organization){
        return iOrganizationService.insertOrganization(organization);
    }

    @RequestMapping("/showOrganization")
    public Organization findOrganizationById(Integer id){
        return iOrganizationService.findOrganization(id);
    }

    @RequestMapping("/showOrganizationByPage")
    public List findOrganizationByPage(Integer count){
        Page page = PageUtil.createPage(10,iOrganizationService.countAll(),count);
        List list = iOrganizationService.findOrganizationByPage(page);
        list.add(page);
        return list;
    }

}
