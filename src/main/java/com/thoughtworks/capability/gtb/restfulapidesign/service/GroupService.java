package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.GroupDto;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.GroupNotExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.pojo.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 17:34
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.service
 * @version: 1.0
 */
@Service
public class GroupService {
    private static final Integer GROUP_COUNT = 6;
    private  final GroupRepository groupRepository;
    private  final StudentRepository studentRepository;
    private List<GroupDto> groupDtoList;

    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository){
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public void updateId(Integer id, String newGroupName) {
        groupRepository.getGroupList().stream().forEach(item ->{
            if (item.getName().equals(newGroupName)){
                throw  new GroupNotExistException(400,"组名已经存在了");
            }
        } );
        groupRepository.getGroupList().get(id - 1).setName(newGroupName);
    }

    public List<GroupDto> group() {
        initGroupList();
        for (GroupDto groupDto : groupDtoList){
            groupDto.getStudentList().clear();
        }
        List<Student> studentList = studentRepository.getStudentList();
        Collections.shuffle(studentList);
        int index = 0;
        for (Student student : studentList){
           groupDtoList.get(index).getStudentList().add(student);
           index = (index + 1) % GROUP_COUNT;
       }
       return groupDtoList;
    }

    public List<GroupDto> getAll() {
        if (groupDtoList == null){
            return  initGroupList();
        }
        return groupDtoList;
    }

    private  List<GroupDto> initGroupList(){
        groupDtoList = new ArrayList<GroupDto>();
        for (int i = 1 ; i <= GROUP_COUNT; i++){
            groupDtoList.add(new GroupDto(groupRepository.getGroupList().get(i-1).getName(),new ArrayList<>()));
        }
        return groupDtoList;
    }
}
