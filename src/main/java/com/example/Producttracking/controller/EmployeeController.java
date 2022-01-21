package com.example.Producttracking.controller;

import com.example.Producttracking.entity.Employee;
import com.example.Producttracking.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployee(){

        return employeeService.getEmployee();
    }


    @PostMapping
    public void registerEmployee (@RequestBody Employee employee){
        employeeService.registerEmployee(employee);
    }

    @DeleteMapping(path = "{emp_id}")
    public void deleteContractor(@PathVariable("emp_id") Long emp_id){
        employeeService.deleteEmployee(emp_id);
    }

    @PutMapping(path = "{emp_id}")
    public void updateEmployee(
            @PathVariable("contractor_id") Long emp_id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phonenumber,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password
    ){
        employeeService.updateEmployee(emp_id, name, email, phonenumber, username, password);
    }
}
