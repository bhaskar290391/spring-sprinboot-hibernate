package com.pratise.thymeleafDemo.controller;

import com.pratise.thymeleafDemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {


    @Value("${countries}")
    private List<String> countries;


    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String studentRegistration(Model theModel){
        Student theStudnet=new Student();
        theModel.addAttribute("student",theStudnet);
        theModel.addAttribute("countries",countries);
        theModel.addAttribute("languages",languages);
        theModel.addAttribute("systems",systems);
        return "student-registration-form";
    }


    @PostMapping("/processStudentForm")
    public String studentRegistration(@ModelAttribute("student") Student theStudent){
        System.out.println("The student is "+theStudent.getFirstName()+" "+theStudent.getLastName());
        return "student-confirmed-form";
    }
}
