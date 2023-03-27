package com.amiel.ThymeleafCrudDatabase.rest;

import com.amiel.ThymeleafCrudDatabase.entity.Employee;
import com.amiel.ThymeleafCrudDatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // Add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model){
        // Get the Employees from the db
        List<Employee> employees = this.employeeService.findAll();
        // Add to the spring model
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    // Add mapping to show an employee
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        // Create model attribute to bind form data
        Employee employee = new Employee();
        // Our thymeleaf template will access this data for binding form data
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate( @RequestParam("employeeId") int id, Model model ){
        // Get the employee from the service
        Employee employee = this.employeeService.findById(id);
        // Set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        // Send over to our form
        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // Save employee
        this.employeeService.save(employee);
        // Use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String showFormForUpdate(@RequestParam("employeeId") int id){
        // Delete the employee
        this.employeeService.deleteById(id);
        // Redirect to /employee/list
        return "redirect:/employees/list";
    }
}
