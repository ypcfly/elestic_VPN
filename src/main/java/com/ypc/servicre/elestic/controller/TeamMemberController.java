package com.ypc.servicre.elestic.controller;

import com.ypc.servicre.elestic.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @Author: ypcfly
 * @Date: 19-7-10 20:31
 * @Description:
 */
@RestController
@RequestMapping("/member")
public class TeamMemberController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/list/{teamId}")
    public Map<String,Object> queryMembers(@PathVariable Integer teamId) {

        return teamService.queryMembers(teamId);
    }

}
