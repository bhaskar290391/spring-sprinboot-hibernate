package com.pratise.thymeleafDemo.model;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;

    private String country;

    private String favouriteLanguage;

    private List<String> operatingSystem;


    public Student(String firstName, String lastName, String country, String favouriteLanguage, List<String> operatingSystem) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.favouriteLanguage = favouriteLanguage;
        this.operatingSystem = operatingSystem;
    }

    public Student(){

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public List<String> getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(List<String> operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
