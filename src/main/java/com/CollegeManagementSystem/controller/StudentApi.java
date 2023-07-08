package com.CollegeManagementSystem.controller;

import com.CollegeManagementSystem.entity.Student;
import com.CollegeManagementSystem.repositiory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;
@Controller
public class StudentApi {
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/admissionData")
    public String admissionData(
            @RequestParam("fname") String fname ,
            @RequestParam("lname") String lname ,
            @RequestParam("fatherName") String fatherName ,
            @RequestParam("motherName") String motherName ,
            @RequestParam("email") String email ,
            @RequestParam("mobile") String mobile,
            @RequestParam("aadhar") String aadhar,
            @RequestParam("className") String className,
            @RequestParam("category") String category,
            @RequestParam("document") String document,
            @RequestParam("address") String address) {

        Student student=Student.builder()
                .id(UUID.randomUUID().toString())
                .firstName(fname)
                .lastName(lname)
                .fatherName(fatherName)
                .motherName(motherName)
                .email(email)
                .phone(mobile)
                .aadhar(aadhar)
                .std(className)
                .category(category)
                .address(address)
                .document(document)
                .build();
        studentRepository.save(student);
        return "Home";
    }

    @GetMapping("/student")
    public String student (Model model) {
        List<Student> AllStudent = studentRepository.findAll();
        model.addAttribute("students",AllStudent);
        System.out.println(AllStudent);
        return "Student";
    }

    @GetMapping("/studentDelete/{id}")
    public String deleteStudent(@PathVariable("id") String id, Model model) {
        studentRepository.deleteById(id);
        List<Student> AllStudent = studentRepository.findAll();
        model.addAttribute("students",AllStudent);
        return "Student";
    }

    @GetMapping("/searchStudent")
    public String searchStudent(Model model, @RequestParam("search") String search) {
        Student student = studentRepository.findById(search).get();
        model.addAttribute("students",student);
        return "Student";
    }
}
