package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/student")
@RestController
public class StudentController {
    @GetMapping("/get-student")
    public Student getStudent(){
        return new Student("jeffrey","Bensouilah");
    }
}
