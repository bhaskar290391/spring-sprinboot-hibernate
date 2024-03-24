package com.practise.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastname;

        @Column(name = "email")
        private String email;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "instructor_detail_id")
        private InstructorDetails details;


        @OneToMany(mappedBy = "instructor",
                fetch = FetchType.LAZY,
                cascade={CascadeType.DETACH,
                CascadeType.PERSIST,
                CascadeType.REFRESH,CascadeType.MERGE})
        private List<Course> courses;


        public Instructor(){

        }

    public Instructor(String firstName, String lastname, String email) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetails getDetails() {
        return details;
    }

    public void setDetails(InstructorDetails details) {
        this.details = details;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    public void add(Course tempCourse){

            if(courses ==null){
                courses =new ArrayList<>();
            }

            courses.add(tempCourse);
            tempCourse.setInstructor(this);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", details=" + details +
                '}';
    }
}
