package com.amiel.SpringDataJPA.service;

import com.amiel.SpringDataJPA.dao.EmployeeRepository;
import com.amiel.SpringDataJPA.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Mark as Service
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = this.employeeRepository.findById(id);

        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        }else{
            // We couldn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return employee;
    }

    // Since we are modifying the DB we need to put Transactional
    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        this.employeeRepository.deleteById(id);
    }
}
