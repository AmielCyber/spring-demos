package com.amielcyber.springboot.cruddemo.dao;

import com.amielcyber.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="members") // /api/members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // That's it... no need to write any code LOL!
}
