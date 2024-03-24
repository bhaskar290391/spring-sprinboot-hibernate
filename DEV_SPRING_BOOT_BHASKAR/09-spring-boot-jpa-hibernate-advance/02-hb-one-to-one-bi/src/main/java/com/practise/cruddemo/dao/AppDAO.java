package com.practise.cruddemo.dao;

import com.practise.cruddemo.entity.Instructor;
import com.practise.cruddemo.entity.InstructorDetails;

public interface AppDAO {

    public void save(Instructor instructor);

    public Instructor findById(int id);

    public void delete(int id);

    public InstructorDetails instructorDetailById(int id);

    public void deleteInstructorDetailById(int id);
}
