package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.pojo.Group;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 15:52
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.repository
 * @version: 1.0
 */
@Repository
public class GroupRepository {

    private static final List<Group> GROUP_LIST = new ArrayList<>();

    private static final Integer GROUP_COUNT = 6;

    static {
        for (int i = 1; i <= GROUP_COUNT; i++){
            GROUP_LIST.add(new Group(i,"第" + i + "组","小组号"));
        }
    }

    public List<Group> getGroupList(){
        return GROUP_LIST;
    }
}
