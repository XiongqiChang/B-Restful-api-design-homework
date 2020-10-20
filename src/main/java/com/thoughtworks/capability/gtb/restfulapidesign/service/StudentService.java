package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentDto;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentHasExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentNotExistException;
import com.thoughtworks.capability.gtb.restfulapidesign.pojo.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 16:02
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.service
 * @version: 1.0
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public  StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void addStudent(StudentDto student) {
        List<Student> students = studentExistList(student.getName());
        if (students.size() != 0){
            throw  new StudentHasExistException(400,"用户名称已经存在");
        }
        int i = (int)(Math.random()*100);
        Student student1 = Student.builder().id(i)
                .gender(student.getGender())
                .name(student.getName())
                .note(student.getNote()).build();
        studentRepository.addStudent(student1);
    }

    public void deleteStudent(Integer id) {
        boolean b = studentRepository.getStudentList().stream().anyMatch(item -> item.getId().equals(id));
        if (!b){
            throw new StudentNotExistException(400,"用户id输入不对");
        }
        studentRepository.deleteStudent(id);
    }

    public List<Student> getAllStudent(String gender) {

        List<Student> studentList = studentRepository.getStudentList();
        if (gender != null){
            List<Student> collect = studentList.stream()
                    .filter(item -> item.getGender().equals(gender))
                    .collect(Collectors.toList());
            return collect;
        }
        return studentList;
    }

    public Student getStudentByName(String name) {

        List<Student> collect = studentExistList(name);
        if (collect.size() == 0){
            throw new StudentNotExistException(400,"用户名称输入错误，用户不存在");
        }
        return collect.get(0);
    }

    public void updateStudentById(Integer id, StudentDto studentDto) {

        Student student = studentRepository.getStudentList().stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (student == null){
            throw  new StudentNotExistException(400,"用户不存在");
        }
        if (studentDto.getName() != null){
            student.setName(studentDto.getName());
        }
        if (studentDto.getGender() != null){
            student.setGender(studentDto.getGender());
        }
        if (studentDto.getName() != null){
            student.setName(studentDto.getName());
        }
    }

    private List<Student> studentExistList(String name){
        return studentRepository.getStudentList()
                .stream().filter(item -> item.getName().equals(name))
                .collect(Collectors.toList());
    }
}
