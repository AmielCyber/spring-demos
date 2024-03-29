package com.amiel.springboot.thymeleafdemo.dao;

import com.amiel.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // That's it... no need to write any code LOL!

    // Add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
