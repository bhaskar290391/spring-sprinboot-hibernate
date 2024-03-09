package com.example.cruddemo.rest;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> findAll(){
        return  employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee =employeeService.findByEmployeeId(employeeId);

        if(theEmployee ==null){
            throw new RuntimeException("Employee not found for ID -->"+employeeId);
        }
        return  theEmployee;
    }


    @PostMapping("/employees")
    public Employee addEmployees(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        return  employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployees(@RequestBody Employee theEmployee){
        return  employeeService.save(theEmployee);
    }


    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee theEmployee =employeeService.findByEmployeeId(employeeId);

        if(theEmployee ==null){
            throw new RuntimeException("Employee not found for ID -->"+employeeId);
        }

        employeeService.delete(employeeId);

        return  "Employee whose ID is  "+employeeId +" deleted from database";
    }
}
