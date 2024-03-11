package com.pratise.thymeleafDemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(){
        return  "helloWorld-form";
    }


    @GetMapping("/processForm")
    public String processForm(){
        return  "helloworld";
    }


    @GetMapping("/processFormV2")
    public String processFormV2(HttpServletRequest request, Model theModel){

        String name=request.getParameter("studentName");
        name=name.toUpperCase();
        String result="Yo !!!! "+name;
        theModel.addAttribute("message",result);
        return  "helloworld";
    }

    @PostMapping("/processFormV3")
    public String processFormV2(@RequestParam("studentName") String name, Model theModel){

        name=name.toUpperCase();
        String result="Yo test 1 !!!! "+name;
        theModel.addAttribute("message",result);
        return  "helloworld";
    }
}
