package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String employeeList(Model theModel){

        List<Employee> theEmployees=service.findAll();
        theModel.addAttribute("employees",theEmployees);
        return "employees/list-employee";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int employeeId, Model theModel){

        Employee employee = service.findById(employeeId);

       theModel.addAttribute("employee",employee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int employeeId){

        service.deleteById(employeeId);
        return "redirect:/employees/list";
    }


    @GetMapping("/showFormToAddEmployee")
    public String showFormToAddEmployee(Model theModel){

        Employee employee =new Employee();
        theModel.addAttribute("employee",employee);
        return "employees/employee-form";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee theEmployee){

        service.save(theEmployee);

        return "redirect:/employees/list";
    }

}
