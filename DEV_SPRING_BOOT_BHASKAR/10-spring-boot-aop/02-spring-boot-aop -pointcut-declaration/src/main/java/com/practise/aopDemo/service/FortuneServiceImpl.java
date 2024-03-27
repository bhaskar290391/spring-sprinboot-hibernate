package com.practise.aopDemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class FortuneServiceImpl implements  FortuneService{
    @Override
    public String getFortuneSevice(boolean tripWire) throws InterruptedException {

        TimeUnit.SECONDS.sleep(5);

    if(tripWire){
        throw  new RuntimeException("Accident occured");
    }

        return "Expecting Heavy traffic in the morning";
    }
}
