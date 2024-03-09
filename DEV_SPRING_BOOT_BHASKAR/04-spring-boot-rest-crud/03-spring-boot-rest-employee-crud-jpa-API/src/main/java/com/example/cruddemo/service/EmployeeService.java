package com.example.cruddemo.service;

import com.example.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();


    Employee findByEmployeeId(int id);

    Employee save(Employee employee);

    void delete(int id);
}
