package com.practise.springboot.springcoredemo.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
