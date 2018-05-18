package db_union.leader.controller;

import db_union.advice.model.Advice;
import db_union.advice.service.IAdviceService;
import db_union.leader.model.Leader;
import db_union.leader.service.ILeaderService;
import db_union.utils.Page;
import db_union.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cirno
 * on 2017/6/18.
 */
@CrossOrigin
@RestController
@RequestMapping("/leader")
@ResponseBody
public class LeaderController {

    private ILeaderService leaderService;
    private IAdviceService adviceService;

    @Autowired
    public void setLeaderService(ILeaderService leaderService,IAdviceService adviceService) {
        this.leaderService = leaderService;
        this.adviceService = adviceService;
    }
    @GetMapping("/")
    public String noPage() {
        return "404";
    }


    @GetMapping("/login")
    public Integer login(Integer id,String password){
        Leader leader = leaderService.findLeaderById(id);
        if(leader == null){
            return 0;
        }else {
            if(leader.getLeaderPassword().equals(password)){
                return 1;
            }else{
                return -1;
            }
        }
    }

    /**
     *
     * TODO
     * @return 领导列表
     */
    @GetMapping("/leaderList")
    public List<Leader> getLeaderList() {

        return leaderService.findLeaderNameList();
    }

    @GetMapping("/adviceForLeader")
    public List<Advice> getAdvicesForLeader(Integer leaderId,Integer COUNT) {
        Page page = PageUtil.createPage(10, adviceService.countAllAdviceByLeaderId(leaderId), COUNT);
//        System.out.println(adviceservice.countAllAdviceByDEPARTMENTID(DEPRTMENTID));
//        System.out.println(DEPRTMENTID);
        HashMap<String, Object> hashmap = new HashMap<String, Object>();
        hashmap.put("leaderId", leaderId);
        hashmap.put("begin", page.getBeginIndex());
        hashmap.put("every", page.getEveryPage());
        List list = adviceService.getAdvicesByLeader(hashmap);
        list.add(page);
        return list;
//        return adviceService.getAdvicesByLeader(leaderId);
    }
}
