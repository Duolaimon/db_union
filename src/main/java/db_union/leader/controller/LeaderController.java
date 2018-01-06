package db_union.leader.controller;

import db_union.leader.model.Leader;
import db_union.leader.service.ILeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cirno
 * on 2017/6/18.
 */
@CrossOrigin
@RestController
@RequestMapping("/leader")
public class LeaderController {

    private ILeaderService leaderService;

    @Autowired
    public void setLeaderService(ILeaderService leaderService) {
        this.leaderService = leaderService;
    }

    @RequestMapping("/login")
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
}
