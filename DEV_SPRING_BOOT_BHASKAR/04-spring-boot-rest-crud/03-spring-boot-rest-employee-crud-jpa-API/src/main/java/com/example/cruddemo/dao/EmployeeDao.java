package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findByEmployeeId(int id);

    Employee save(Employee employee);

    void delete(int id);
}
