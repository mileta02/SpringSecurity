package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    List<Student> list = new ArrayList<>(Arrays.asList(
            new Student(1,"Milan","Spring"),
            new Student(1,"Vuk","Python"),
            new Student(1,"Andrej","React")
    ));
    @GetMapping("students")
    public List<Student> getStudents(){
        return list;
    }

    @PostMapping("students")
    public void addStudent(@RequestBody Student student){
        list.add(student);
    }

    @GetMapping("csrf")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
