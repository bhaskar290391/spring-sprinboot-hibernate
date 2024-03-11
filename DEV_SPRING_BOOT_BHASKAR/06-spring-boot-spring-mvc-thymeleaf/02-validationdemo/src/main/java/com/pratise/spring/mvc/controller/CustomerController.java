package com.pratise.spring.mvc.controller;

import com.pratise.spring.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        StringTrimmerEditor editor=new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class,editor);
    }

    @GetMapping("/")
    public String showCustomerForm(Model theModel){
        Customer theCustomer=new Customer();
        theModel.addAttribute("customer",theCustomer);
        return  "customer-form";
    }



    @PostMapping("processCustomerForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult theBindingResult){

        System.out.println(theBindingResult.toString());
        if (theBindingResult.hasErrors()){
            return "customer-form";
        }else{
            return  "customer-confirmation";
        }
    }
}
