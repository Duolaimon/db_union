package db_union.team.controller;

import db_union.team.model.Team;
import db_union.team.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cirno
 * on 2017/10/6.
 */
@CrossOrigin
@RestController
@RequestMapping("/team")
public class TeamController {

    private ITeamService iTeamService;

    @Autowired
    public void setiTeamService(ITeamService iTeamService) {
        this.iTeamService = iTeamService;
    }
    @GetMapping("/")
    public String noPage() {
        return "404";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Integer login(Integer id,String password){
        Team team = iTeamService.findTeamById(id);
        if(team == null){
            return 0;
        }else {
            if(team.getTeamPass().equals(password)){
                return 1;
            }else{
                return -1;
            }
        }
    }
}
