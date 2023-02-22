package com.amielcyber.springboot.cruddemo.rest;

import com.amielcyber.springboot.cruddemo.dao.EmployeeDAO;
import com.amielcyber.springboot.cruddemo.entity.Employee;
import com.amielcyber.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    /*
    private EmployeeDAO employeeDAO;
    // Quick and dirty: inject employee dao (use constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }
    */
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // Expose "/employees" and return list of employees
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
    // Add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // In case they pass an id in JSON.. set id to 0
        // this is to force a save of new item ... instead of update
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    // Add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        this.employeeService.save(employee);
        return employee;
    }

    // Add mapping for DELETE /employees/{employeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = this.employeeService.findById(employeeId);
        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
