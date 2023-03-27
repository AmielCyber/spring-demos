package com.amiel.ThymeleafCrudDatabase.service;


import com.amiel.ThymeleafCrudDatabase.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
