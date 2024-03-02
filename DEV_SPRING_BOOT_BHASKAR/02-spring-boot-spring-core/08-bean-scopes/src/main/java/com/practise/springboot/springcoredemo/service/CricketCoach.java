package com.practise.springboot.springcoredemo.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class CricketCoach  implements  Coach{



    public CricketCoach() {
        System.out.println("In constructor -->"+getClass().getSimpleName());
    }
    /**
     * Display DailyWorkout
     */
    @Override
    public String getDailyWorkOut() {
        return "Practise Fast bowling for 15 mins";
    }
}
