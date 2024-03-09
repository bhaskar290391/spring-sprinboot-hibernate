package com.example.demo.rest;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFound;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private static List<Student> theStudents;

    @PostConstruct
    public static void loadData(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("bhaskar","mudaliyar"));
        theStudents.add(new Student("Maddy","Bhaskar"));
        theStudents.add(new Student("Kanishk","Sam"));
    }

    @GetMapping("/students")
    public List<Student> getStudentList(){
        return  theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student studentById(@PathVariable int studentId){

       if(studentId >theStudents.size() || studentId<0){
           throw  new StudentNotFound("Student is not found for ID --->"+studentId);
       }

        return  theStudents.get(studentId);
    }
}
