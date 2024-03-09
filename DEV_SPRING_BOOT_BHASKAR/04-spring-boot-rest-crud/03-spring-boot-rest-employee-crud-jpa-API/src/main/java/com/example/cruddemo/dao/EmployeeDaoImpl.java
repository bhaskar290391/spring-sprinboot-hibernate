package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements  EmployeeDao{


    private final EntityManager theManager;

    @Autowired
    EmployeeDaoImpl(EntityManager theManager){
        this.theManager=theManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theEmployee= theManager.createQuery("From Employee", Employee.class);

        List<Employee> resultList = theEmployee.getResultList();
        return resultList;
    }


    @Override
    public Employee findByEmployeeId(int id) {
        Employee employee=theManager.find(Employee.class,id);
        return employee;
    }


    @Override
    public Employee save(Employee employee) {

        Employee employees=theManager.merge(employee);
        return employees;
    }


    @Override
    public void delete(int id) {
        Employee employee=theManager.find(Employee.class,id);
        theManager.remove(employee);
    }
}
