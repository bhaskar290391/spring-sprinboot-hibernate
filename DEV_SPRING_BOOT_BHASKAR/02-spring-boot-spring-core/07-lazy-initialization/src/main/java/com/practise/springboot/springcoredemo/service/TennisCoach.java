package com.practise.springboot.springcoredemo.service;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements  Coach{

    public TennisCoach() {
        System.out.println("In constructor -->"+getClass().getSimpleName());
    }
    /**
     * Display DailyWorkout
     */
    @Override
    public String getDailyWorkOut() {
        return "practise Backend Valley";
    }
}
