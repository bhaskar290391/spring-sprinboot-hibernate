package com.practise.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String helloWorld(){
        return  "Hello World";
    }

    @GetMapping("/workout")
    public String workourk(){
        return  "Run hard 5k";
    }


    @GetMapping("/fortune")
    public String fortune(){
        return  "Today is your lucky day";
    }
}
