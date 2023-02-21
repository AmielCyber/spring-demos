package com.amielcyber.springboot.cruddemo.dao;

import com.amielcyber.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
    // Define field for entity manager
    private EntityManager entityManager;

    // Set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    //@Transactional  // Handles transaction management so do not do manually commit all transaction
    public List<Employee> findAll() {
        // Get the current hibernate session
        Session currentSession = this.entityManager.unwrap(Session.class);
        // Create a query
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
        // Execute query and get the result list
        List<Employee> employees = query.getResultList();
        // Return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // Get the current hibernate session
        Session currentSession = this.entityManager.unwrap(Session.class);
        // Get the employee
        Employee employee = currentSession.get(Employee.class, id);
        // Return the employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        // Get the current hibernate session
        Session currentSession = this.entityManager.unwrap(Session.class);
        // Save the employee
        currentSession.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        // Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // Delete Object with primary key
        Query<Employee> query = currentSession.createQuery("DELETE FROM Employee WHERE id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
