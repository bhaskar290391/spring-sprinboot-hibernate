package com.practise.springboot.springcoredemo.service;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements  Coach{
    /**
     * Display DailyWorkout
     */
    @Override
    public String getDailyWorkOut() {
        return "Run a hard 5k";
    }
}
