package com.practise.cruddemo.dao;

import com.practise.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    public  void saveStudent(Student student);

    public Student readStudent(int id);

    public List<Student> readAllStudents();

    public List<Student> readStudentByLastName(String lastName);

    public Student updateStudent(Student theStudent);

    public void deleteStudentById(Student theStudent);

    public int deleteAllStudent();
}
