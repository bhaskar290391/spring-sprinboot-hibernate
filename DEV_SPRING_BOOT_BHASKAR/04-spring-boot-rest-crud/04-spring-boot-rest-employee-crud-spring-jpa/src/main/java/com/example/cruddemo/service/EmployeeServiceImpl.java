package com.example.cruddemo.service;

import com.example.cruddemo.dao.EmployeeRepository;
import com.example.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepository employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findByEmployeeId(int id) {
        Optional<Employee> data = employeeDao.findById(id);

        Employee employeeData=null;
        if(data.isPresent()){
            employeeData=data.get();
        }else{
            throw new RuntimeException("Data not Found for Employee --> "+ id);
        }
        return employeeData;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDao.deleteById(id);
    }
}
