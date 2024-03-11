package com.pratise.spring.mvc.model;


import com.pratise.spring.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is Required")
    @Size(min =1 ,message = "is Required")
    private String lastName;

    @NotNull(message = "is Required")
    @Min(value = 0,message = "Must be equal or greater then Zero")
    @Max(value = 10,message = "Must be equal or lesser then Ten")
    private  Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "Only enter 5 character/number")
    private  String postalCode;


    @CourseCode
    private String courseCode ;

    public Customer(){

    }

    public Customer(String firstName, String lastName,Integer freePasses,String postalCode,String courseCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.freePasses=freePasses;
        this.postalCode=postalCode;
        this.courseCode=courseCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
