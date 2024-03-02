package com.practise.springboot.springcoredemo.service;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach  implements  Coach{
    /**
     * Display DailyWorkout
     */
    @Override
    public String getDailyWorkOut() {
        return "Practise Fast bowling for 15 mins";
    }
}
