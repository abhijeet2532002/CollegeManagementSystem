package com.CollegeManagementSystem.controller;

import com.CollegeManagementSystem.entity.Subject;
import com.CollegeManagementSystem.entity.Teacher;
import com.CollegeManagementSystem.repositiory.SubjectRepository;
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
public class SubjectApi {
    @Autowired
    private SubjectRepository subjectRepository;
    @GetMapping("/subject")
    public String teachers(Model model){
        List<Subject> AllSubject = subjectRepository.findAll();
        model.addAttribute("subjects",AllSubject);
        return "SubjectPage";
    }

    @GetMapping("/addSubject")
    public String addTeacher() {
        return "AddSubject";
    }
    @PostMapping("/addSubjectData")
    public String addSubjectData(Model model,
            @RequestParam("name") String name ,
            @RequestParam("semister") String semister ,
            @RequestParam("marks") String marks
    ) {
        Subject subject = Subject.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .semister(semister)
                .marks(marks).build();
        subjectRepository.save(subject);

        List<Subject> AllSubject = subjectRepository.findAll();
        model.addAttribute("subjects",AllSubject);
        return "SubjectPage";
    }

    @GetMapping("/searchSubject")
    public String searchStudent(Model model, @RequestParam("searchTeacher") String search) {
        Subject subject = subjectRepository.findById(search).get();
        model.addAttribute("subjects",subject);
        return "SubjectPage";
    }

    @GetMapping("/deleteSubject/{id}")
    public String deleteTeacher(@PathVariable("id") String id, Model model) {
        subjectRepository.deleteById(id);
        List<Subject> AllSubject = subjectRepository.findAll();
        model.addAttribute("subjects",AllSubject);
        return "SubjectPage";
    }
}
