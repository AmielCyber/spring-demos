package com.amiel.SpringBootSecurity.rest;

import com.amiel.SpringBootSecurity.entity.Employee;
import com.amiel.SpringBootSecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;
    // Inject emp service
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return this.employeeService.findAll();
    }

    // Add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = this.employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return employee;
    }

    // Add mapping for POST /employees
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // Just in case they pass an id in JSON ... set id to 0 to force a save of new item
        employee.setId(0);
        Employee dbEmployee = this.employeeService.save(employee);
        return dbEmployee;
    }

    // Add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updatedEmployee(@RequestBody Employee employee){
        Employee dbEmployee = this.employeeService.save(employee);

        return dbEmployee;
    }

    // Add mapping for DELETE /employees/{employeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = this.employeeService.findById(employeeId);
        // throw exception if null
        if(employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        this.employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}
