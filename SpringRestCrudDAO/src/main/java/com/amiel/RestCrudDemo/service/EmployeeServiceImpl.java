package com.amiel.RestCrudDemo.service;

import com.amiel.RestCrudDemo.dao.EmployeeDAO;
import com.amiel.RestCrudDemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Mark as Service
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeDAO.findById(id);
    }

    // Since we are modifying the DB we need to put Transactional
    @Transactional
    @Override
    public Employee save(Employee employee) {
        return this.employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        this.employeeDAO.deleteById(id);
    }
}
