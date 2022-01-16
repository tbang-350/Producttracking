package com.example.Producttracking.repository;

import com.example.Producttracking.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
