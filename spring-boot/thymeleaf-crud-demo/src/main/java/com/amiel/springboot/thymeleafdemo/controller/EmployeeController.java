package com.amiel.springboot.thymeleafdemo.controller;

import com.amiel.springboot.thymeleafdemo.entity.Employee;
import com.amiel.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    // Auto wired is optional since we only have 1 constructor.
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // Add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model){
        // Get employees from database.
        List<Employee> employees = employeeService.findAll();
        // Add to the Spring model
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        // Create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/employee-form";   // Return template we will use.
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        // Get the employee from the service
        Employee employee = employeeService.findById(id);
        // Set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        // Send over to our form
        return "employees/employee-form";

    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // Save the employee
        employeeService.save(employee);
        // Use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        // Delete the employee
        employeeService.deleteById(id);
        // Redirect to /employees/list
        return "redirect:/employees/list";
    }
}
