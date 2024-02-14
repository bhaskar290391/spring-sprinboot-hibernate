package com.practise.springboot.springcoredemo.service;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements  Coach{
    /**
     * Display DailyWorkout
     */
    @Override
    public String getDailyWorkOut() {
        return "Practise Backend Valley";
    }
}
