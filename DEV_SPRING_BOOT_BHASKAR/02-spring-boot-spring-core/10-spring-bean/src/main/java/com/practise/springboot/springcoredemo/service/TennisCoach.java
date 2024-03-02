package com.practise.springboot.springcoredemo.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
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
