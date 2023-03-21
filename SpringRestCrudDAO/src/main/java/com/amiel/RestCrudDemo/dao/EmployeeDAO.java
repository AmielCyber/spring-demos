package com.amiel.RestCrudDemo.dao;

import com.amiel.RestCrudDemo.entity.Employee;
import java.util.List;

// Data Access Object
public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
