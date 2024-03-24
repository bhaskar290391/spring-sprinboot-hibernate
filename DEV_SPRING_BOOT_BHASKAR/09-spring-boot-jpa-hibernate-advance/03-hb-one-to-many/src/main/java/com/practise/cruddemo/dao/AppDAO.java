package com.practise.cruddemo.dao;

import com.practise.cruddemo.entity.Course;
import com.practise.cruddemo.entity.Instructor;
import com.practise.cruddemo.entity.InstructorDetails;

import java.util.List;

public interface AppDAO {

    public void save(Instructor instructor);

    public Instructor findById(int id);

    public void delete(int id);

    public InstructorDetails instructorDetailById(int id);

    public void deleteInstructorDetailById(int id);

    List<Course> fetchCourseByInstructorId(int id);

    Instructor fetchInstructorWithCourseUsingJoinFetch(int id);

    Instructor UpdateInstructor(Instructor instructor);

    Course UpdateCourse(Course course);

    public Course findCourseById(int id);

    void deleteCourseById(int id);
}
