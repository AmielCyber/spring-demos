package com.amiel.springboot.thymeleafdemo.controller;

import com.amiel.springboot.thymeleafdemo.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployeeController {
    // Load employee data
    private List<Employee> employees;

    @PostConstruct
    private void loadData(){
        // Create employees.
        Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@luv2code.com");
        Employee emp2 = new Employee(2, "Emma", "Baumgarten", "emma@luv2code.com");
        Employee emp3 = new Employee(3, "Avani", "Gupta", "avani@luv2code.com");
        // Create the list
        this.employees = new ArrayList<>();
        // Add to the list
        this.employees.add(emp1);
        this.employees.add(emp2);
        this.employees.add(emp3);
    }

    // Add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees", this.employees);
        return "list-employees";
    }
}
