package com.practise.springboot.springcoredemo.service;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements  Coach{
    public BaseBallCoach() {
        System.out.println("In constructor -->"+getClass().getSimpleName());
    }

    /**
     * Display DailyWorkout
     */
    @Override
    public String getDailyWorkOut() {
        return "Practise batting for  1 hour";
    }
}
