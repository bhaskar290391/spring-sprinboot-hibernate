package com.practise.cruddemo.dao;

import com.practise.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoIMPL implements  StudentDao{


    private EntityManager manager;

    @Autowired
    public StudentDaoIMPL(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        manager.persist(student);
    }

    @Override
    public Student readStudent(int id) {
        Student theStudent=manager.find(Student.class,id);
        return theStudent;
    }

    @Override
    public List<Student> readAllStudents() {
        return manager.createQuery("From Student",Student.class).getResultList();
    }

    @Override
    public List<Student> readStudentByLastName(String lastName) {
        TypedQuery<Student> query = manager.createQuery("From Student where lastName=:theData", Student.class);
        query.setParameter("theData",lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Student updateStudent(Student theStudent) {
        Student merge = manager.merge(theStudent);
        return merge;
    }

    @Override
    @Transactional
    public void deleteStudentById(Student theStudent) {
        manager.createQuery("delete from Student where id="+theStudent.getId()).executeUpdate();
    }

    @Override
    @Transactional
    public int deleteAllStudent() {
        return manager.createQuery("delete from Student").executeUpdate();
    }
}
