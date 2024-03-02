package com.practise.springboot.springcoredemo.service;

import org.springframework.stereotype.Component;


public class SwimCoach implements  Coach{
    public SwimCoach() {
        System.out.println("In constructor -->"+getClass().getSimpleName());
    }

    /**
     * Display DailyWorkout
     */
    @Override
    public String getDailyWorkOut() {
        return "Swim 1000 m with in 1 hour";
    }
}
