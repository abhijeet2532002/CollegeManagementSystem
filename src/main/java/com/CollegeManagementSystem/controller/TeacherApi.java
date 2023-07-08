package com.CollegeManagementSystem.controller;

import com.CollegeManagementSystem.entity.Student;
import com.CollegeManagementSystem.entity.Teacher;
import com.CollegeManagementSystem.repositiory.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class TeacherApi {
    @Autowired
    private TeacherRepository teacherRepository;
    @GetMapping("/teacher")
    public String teachers(Model model){
        List<Teacher> AllTeacher = teacherRepository.findAll();
        model.addAttribute("teachers",AllTeacher);
        return "TeacherPage";
    }

    @GetMapping("/addTeacher")
    public String addTeacher() {
        return "AddTeacher";
    }
    @PostMapping("/addTeacherData")
    public String addTeacherData(Model model,
            @RequestParam("fname") String fname ,
            @RequestParam("lname") String lname ,
            @RequestParam("email") String email ,
            @RequestParam("mobile") String mobile,
            @RequestParam("aadhar") String aadhar,
            @RequestParam("qualification") String qualification,
            @RequestParam("gender") String gender,
            @RequestParam("document") String document,
            @RequestParam("address") String address
    ) {
        Teacher teacher = Teacher.builder()
                .id(UUID.randomUUID().toString())
                .firstName(fname)
                .lastName(lname)
                .email(email)
                .phone(mobile)
                .aadhar(aadhar)
                .qualification(qualification)
                .gender(gender)
                .address(address)
                .document(document)
                .build();
        teacherRepository.save(teacher);

        List<Teacher> AllTeacher = teacherRepository.findAll();
        model.addAttribute("teachers",AllTeacher);
        return "TeacherPage";
    }

    @GetMapping("/searchTeacher")
    public String searchStudent(Model model, @RequestParam("searchTeacher") String search) {
        Teacher teacher = teacherRepository.findById(search).get();
        model.addAttribute("teachers",teacher);
        return "TeacherPage";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable("id") String id, Model model) {
        teacherRepository.deleteById(id);
        List<Teacher> AllTeacher = teacherRepository.findAll();
        model.addAttribute("teachers",AllTeacher);
        return "TeacherPage";
    }
}
