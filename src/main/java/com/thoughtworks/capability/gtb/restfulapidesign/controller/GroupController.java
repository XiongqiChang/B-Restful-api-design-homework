package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.GroupDto;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 17:32
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.controller
 * @version: 1.0
 */
@RestController
@Slf4j
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @PatchMapping("/group/{id}/{name}")
    public void updateGroup(@PathVariable("id")Integer id,
                            @PathVariable("name") String newGroupName){
        groupService.updateId(id,newGroupName);

    }

    @GetMapping("/groups")
    public List<GroupDto> getAllList(){
       return groupService.getAll();
    }

    @PostMapping("/group")
    @ResponseStatus(HttpStatus.CREATED)
    public List<GroupDto>  createGroup(){
        return groupService.group();
    }


}
