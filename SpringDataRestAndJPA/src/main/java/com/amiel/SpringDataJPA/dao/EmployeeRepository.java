package com.amiel.SpringDataJPA.dao;

import com.amiel.SpringDataJPA.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Repository will have all CRUD methods out of the box

// @RepositoryRestResource(path = "members")// http://localhost:8080/members/
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
