package com.amielcyber.springboot.cruddemo.dao;

import com.amielcyber.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        // Create a query
        Query query = entityManager.createQuery("from Employee");
        // Execute query and get result list
        List<Employee> employees = query.getResultList();
        // Return the results.
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // Get employee
        Employee employee = entityManager.find(Employee.class, id);
        // Return employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        // Save or Update the employee
        Employee dbEmployee = entityManager.merge(employee);
        // Update with id from db... so we can get generated id for save/insert.
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        // Delete object with primary key
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
