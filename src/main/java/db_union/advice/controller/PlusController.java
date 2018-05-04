package db_union.advice.controller;

import db_union.advice.model.Advice;
import db_union.advice.service.IAdviceService;
import db_union.utils.Page;
import db_union.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cirno
 * on 2017/10/5.
 */
@CrossOrigin
@RestController
@RequestMapping("/plus")
public class PlusController {

    private IAdviceService adviceservice;

    @Autowired
    public void setAdviceservice(IAdviceService adviceservice) {
        this.adviceservice = adviceservice;
    }

    /**
     * 设置转为提案的部门
     * @param id
     * @param dmid
     * @return
     */
    @RequestMapping(value = "/setNewCount",method = RequestMethod.POST)
    public Integer setNewCount(Integer id,String dmid,String adnum){
        Advice advice = adviceservice.findAdviceByID(id);
        if(advice==null){
            //id对应的建议不存在
            return 0;
        }else{
            //状态码6代表转为提案的建议
            advice.setAdviceState(6);
            advice.setDepartmentId(dmid);
            advice.setAdviceNum(adnum);
            Integer count = adviceservice.updateByPrimaryKeySelective(advice);

            if(count>0){
                return 1;
            }else{
                return -1;
            }
        }
    }

    /**
     *根据部门和页码查询转为建议的提案
     * @param count
     * @param dmid
     * @return
     */
    @RequestMapping(value = "/state6ByDmid",method = RequestMethod.GET)
        public List state6ByDmid(Integer count,String dmid){
        Page page = PageUtil.createPage(10,adviceservice.countState6ByDmid(dmid),count);
        HashMap map = new HashMap<String,Object>();
        map.put("id",dmid);
        map.put("begin",page.getBeginIndex());
        map.put("every",page.getEveryPage());
        List list = adviceservice.select6ByDmid(map);
        list.add(page);
        return list;
    }

    /**
     *
     * @param id
     * @param stateid
     * @return
     */
    @RequestMapping(value = "/updateState",method = RequestMethod.POST)
    public Integer updateState(Integer id,Integer stateid){
        Advice advice = adviceservice.findAdviceByID(id);
        System.out.println(id+"---"+stateid);
        advice.setAdviceState(stateid);
        Integer count = adviceservice.updateByPrimaryKeySelective(advice);
        if(count>0){
            return 1;
        }else{
            return -1;
        }
    }

    /**
     *
     * @param stateid
     * @param count
     * @return
     */
    @RequestMapping(value = "/getAllState",method = RequestMethod.GET)
    public List selectAllState(Integer stateid, Integer count){
        System.out.println(stateid+"---"+count);
        Page page = PageUtil.createPage(10,adviceservice.countAllState(stateid),count);
        HashMap map = new HashMap<String,Object>();
        map.put("id",stateid);
        map.put("begin",page.getBeginIndex());
        map.put("every",page.getEveryPage());
        List list = adviceservice.selectAllState(map);
        list.add(page);
        return  list;
    }

    @RequestMapping(value = "/updateTitle" , method = RequestMethod.POST)
    public Integer updateTitle(Integer id,String title){

        Advice advice = adviceservice.findAdviceByID(id);
        if(advice != null){
            advice.setAdviceTitle(title);
            int count = adviceservice.updateByPrimaryKeySelective(advice);
            return count ;
        }else{
            return 0;
        }
    }
}
