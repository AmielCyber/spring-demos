package com.amiel.SpringDataJPA.dao;

import com.amiel.SpringDataJPA.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository will have all CRUD methods out of the box
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
