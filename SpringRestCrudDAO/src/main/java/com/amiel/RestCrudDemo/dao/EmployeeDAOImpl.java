package com.amiel.RestCrudDemo.dao;

import com.amiel.RestCrudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// Mark as Repository for DAO
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    // Define field for entity-manager
    private final EntityManager entityManager;

    // Set up constructor injection

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        // Execute query and get result list
        List<Employee> employees = query.getResultList();
        // Return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // Get employee
        Employee employee = this.entityManager.find(Employee.class, id);
        // Return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // Save employee
        // Merge save/insert if id === 0, else update
        Employee dbEmployee = this.entityManager.merge(employee);
        // Return the dbEmployee, since it has the updated id.
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        // Find employee by id
        Employee employee = this.entityManager.find(Employee.class, id);
        // Remove employee
        this.entityManager.remove(employee);
    }
}
