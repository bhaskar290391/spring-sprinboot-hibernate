package com.practise.springboot.springcoredemo.config;

import com.practise.springboot.springcoredemo.service.Coach;
import com.practise.springboot.springcoredemo.service.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        return  new SwimCoach();
    }
}
