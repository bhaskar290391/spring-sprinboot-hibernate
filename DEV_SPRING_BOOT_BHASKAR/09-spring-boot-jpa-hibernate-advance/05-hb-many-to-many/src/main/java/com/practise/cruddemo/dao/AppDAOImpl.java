package com.practise.cruddemo.dao;

import com.practise.cruddemo.entity.Course;
import com.practise.cruddemo.entity.Instructor;
import com.practise.cruddemo.entity.InstructorDetails;
import com.practise.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements  AppDAO{

    private EntityManager manager;

    AppDAOImpl(EntityManager manager){
        this.manager=manager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        manager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        Instructor instructor=manager.find(Instructor.class,id);
        return instructor;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor instructor=manager.find(Instructor.class,id);

        List<Course> theCourse=instructor.getCourses();

        for (Course course:
        theCourse ) {
            course.setInstructor(null);
        }
        manager.remove(instructor);
    }

    @Override
    public InstructorDetails instructorDetailById(int id) {
        InstructorDetails details=manager.find(InstructorDetails.class,id);
        return details;
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        InstructorDetails details=manager.find(InstructorDetails.class,id);

        details.getInstructor().setDetails(null);

        manager.remove(details);

    }

    @Override
    public List<Course> fetchCourseByInstructorId(int id) {

        TypedQuery<Course> query=manager.createQuery("from Course where instructor.id=:data",Course.class);
        query.setParameter("data",id);
        return  query.getResultList();
    }

    @Override
    public Instructor fetchInstructorWithCourseUsingJoinFetch(int id) {

        TypedQuery<Instructor> instructor=manager.createQuery("select i from Instructor i" +
                " join fetch i.courses " +
                " join fetch i.details "
                + "where i.id=:data",Instructor.class );

        instructor.setParameter("data",id);

        return instructor.getSingleResult();
    }

    @Override
    @Transactional
    public Instructor UpdateInstructor(Instructor instructor) {
        Instructor instructor1=manager.merge(instructor);
        return  instructor1;
    }

    @Override
    @Transactional
    public Course UpdateCourse(Course course) {
        Course course1 = manager.merge(course);
        return course1;
    }

    public Course findCourseById(int id){
       Course theCourse=manager.find(Course.class,id);
       return  theCourse;
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course theCourse=manager.find(Course.class,id);
        manager.remove(theCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        manager.persist(theCourse);
    }

    @Override
    public Course fetchCourseAndReviewByCourseid(int id) {

        TypedQuery<Course> query=manager.createQuery("Select i from Course i join fetch i.reviews where i.id =:data",Course.class);
        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void createCourseAndStudents(Course course) {
        manager.persist(course);
    }

    @Override
    public Course findCourseAndStudentByCourseId(int id) {

        TypedQuery<Course> query=manager.createQuery("select c from Course c " +
                "join fetch c.students " +
                "where c.id=:data",Course.class);

        query.setParameter("data",id);


        return query.getSingleResult();
    }

    @Override
    public Student findStudentsAndCourseByStudentId(int id) {
        TypedQuery<Student> query=manager.createQuery("select s from Student s " +
                "join fetch s.courses " +
                "where s.id=:data",Student.class);

        query.setParameter("data",id);


        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {

        Student student = manager.find(Student.class,id);
        manager.remove(student);
    }
}
