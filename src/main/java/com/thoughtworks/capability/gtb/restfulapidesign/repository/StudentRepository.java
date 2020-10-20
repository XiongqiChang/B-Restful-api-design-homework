package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 15:44
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.repository
 * @version: 1.0
 */
@Repository
public class StudentRepository {

    private static final List<Student> STUDENT_LIST = new ArrayList<>();

    static  {
        STUDENT_LIST.add(new Student(1,"刘禅","男","三国人物"));
        STUDENT_LIST.add(new Student(2,"刘备","男","三国人物"));
        STUDENT_LIST.add(new Student(3,"孙尚香","女","三国人物"));
        STUDENT_LIST.add(new Student(4,"关羽","男","三国人物"));
        STUDENT_LIST.add(new Student(5,"张飞","男","三国人物"));
        STUDENT_LIST.add(new Student(6,"甄姬","女","三国人物"));
        STUDENT_LIST.add(new Student(7,"黄月英","女","三国人物"));
    }

    public List<Student> getStudentList(){
        return STUDENT_LIST;
    }

    public void addStudent(Student student1) {
        STUDENT_LIST.add(student1);
    }

    public void deleteStudent(Integer id) {
        List<Student> collect = STUDENT_LIST.stream()
                .filter(item -> item.getId().equals(id))
                .collect(Collectors.toList());
        STUDENT_LIST.remove(collect.get(0));

    }
}
