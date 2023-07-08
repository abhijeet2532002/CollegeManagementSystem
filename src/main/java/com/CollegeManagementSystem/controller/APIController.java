package com.CollegeManagementSystem.controller;

import com.CollegeManagementSystem.entity.Student;
import com.CollegeManagementSystem.repositiory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class APIController {
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/home")
    public String home() {
        return "Home";
    }
    @GetMapping("/admission")
    public String admission() {
        return "Admission";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Dashboard";
    }
    @GetMapping("C")
    public String holiday() {
        return "Holiday";
    }
    @GetMapping("/syllabus")
    public String syllabus() {
        return "Syllabus";
    }
}
