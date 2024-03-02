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


    @PostConstruct
    public void postConstruct(){
        System.out.println("Post construct method");
    }


    @PreDestroy
    public void preDestroy(){
        System.out.println("Pre  Destroy method");
    }
    /**
     * Display DailyWorkout
     */
    @Override
    public String getDailyWorkOut() {
        return "practise Backend Valley";
    }
}
