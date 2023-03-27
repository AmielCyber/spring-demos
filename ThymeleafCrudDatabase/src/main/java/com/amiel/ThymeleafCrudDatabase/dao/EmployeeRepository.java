package com.amiel.ThymeleafCrudDatabase.dao;

import com.amiel.ThymeleafCrudDatabase.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// Repository will have all CRUD methods out of the box
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Add a method to sort by last name
    // Spring Data JPA will parse the method name
    // Looks for a specific format and patter Creates appropriate query behind the scenes
    public List<Employee> findAllByOrderByLastNameAsc();
}
