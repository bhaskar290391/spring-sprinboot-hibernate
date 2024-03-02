package com.practise.springboot.springcoredemo.rest;

import com.practise.springboot.springcoredemo.service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    private Coach myCoach;

    private Coach anotherCoach;


    DemoController(@Qualifier("tennisCoach") Coach  theCoach,
                   @Qualifier("tennisCoach") Coach  theAnotherCoach){
        System.out.println("In constructor -->"+getClass().getSimpleName());
        myCoach=theCoach;
        anotherCoach=theAnotherCoach;
    }

    @GetMapping("/dailyWorkout")
    public String dailyWorkout(){
        return myCoach.getDailyWorkOut();
    }

    @GetMapping("/check")
    public String check(){
        return( "Comparing Bean : myCoach == anotherCoach, "+(myCoach == anotherCoach));
    }
}
