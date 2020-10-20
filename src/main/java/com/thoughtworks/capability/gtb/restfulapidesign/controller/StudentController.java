package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentDto;
import com.thoughtworks.capability.gtb.restfulapidesign.pojo.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 16:03
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.controller
 * @version: 1.0
 */
@RestController
public class StudentController {
    private final  StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody StudentDto student){
            studentService.addStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/students")
    public List<Student> students(@RequestParam(required = false) String gender){
        return  studentService.getAllStudent(gender);
    }

    @GetMapping("/student/{name}")
    public Student getStudent(@PathVariable("name")String name){
        return studentService.getStudentByName(name);
    }

    @PatchMapping("/student/{id}")
    public void updateById(@PathVariable("id")Integer id,
                           @RequestBody StudentDto studentDto){
        studentService.updateStudentById(id,studentDto);
    }




}
