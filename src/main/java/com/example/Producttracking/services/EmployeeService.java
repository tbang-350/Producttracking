package com.example.Producttracking.services;

import com.example.Producttracking.entity.Employee;
import com.example.Producttracking.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }
}
