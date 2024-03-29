package com.amielcyber.springboot.cruddemo.service;

import com.amielcyber.springboot.cruddemo.dao.EmployeeDAO;
import com.amielcyber.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    @Autowired  // Constructor Injection
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }
    @Override
    @Transactional
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return this.employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        this.employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        this.employeeDAO.deleteById(id);
    }
}
