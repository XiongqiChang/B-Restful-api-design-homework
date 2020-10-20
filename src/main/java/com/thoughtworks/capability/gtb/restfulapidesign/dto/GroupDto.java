package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import com.thoughtworks.capability.gtb.restfulapidesign.pojo.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 18:01
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.dto
 * @version: 1.0
 */
@Data
@AllArgsConstructor
public class GroupDto {

    private String name;

    private List<Student> studentList;

}
