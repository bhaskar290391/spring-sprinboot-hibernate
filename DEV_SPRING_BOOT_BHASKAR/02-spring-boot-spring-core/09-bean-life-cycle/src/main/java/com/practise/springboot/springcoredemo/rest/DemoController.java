package com.practise.springboot.springcoredemo.rest;

import com.practise.springboot.springcoredemo.service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    private Coach myCoach;




    DemoController(@Qualifier("tennisCoach") Coach  theCoach
                   ){
        System.out.println("In constructor -->"+getClass().getSimpleName());
        myCoach=theCoach;

    }

    @GetMapping("/dailyWorkout")
    public String dailyWorkout(){
        return myCoach.getDailyWorkOut();
    }


}
