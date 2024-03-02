package com.practise.springboot.springcoredemo.service;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements  Coach{
    /**
     * Display DailyWorkout
     */
    @Override
    public String getDailyWorkOut() {
        return "Practise batting for  1 hour";
    }
}
