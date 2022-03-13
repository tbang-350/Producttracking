package com.example.Producttracking.services;

import com.example.Producttracking.dto.EmployeeDto;
import com.example.Producttracking.dto.GetEmployeeDto;
import com.example.Producttracking.entity.Contractors;
import com.example.Producttracking.entity.Employee;
import com.example.Producttracking.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }


    public List<GetEmployeeDto> getEmployee() {
        List<GetEmployeeDto> list = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();
        for(Employee emp : employees){
            list.add(mapper.map(emp,GetEmployeeDto.class));
        }
        return list;
    }

    public void registerEmployee(EmployeeDto employeeDto) {

        Employee employee = mapper.map(employeeDto,Employee.class);

        Optional<Employee> contractorOptional = employeeRepository.findEmployeeByUsername(employee.getUsername());

        if (contractorOptional.isPresent()){
            throw new IllegalStateException("contractor exists");
        }

        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long emp_id) {
        boolean exists = employeeRepository.existsById(emp_id);

        if (!exists){
            throw new IllegalStateException("contractor with id "+emp_id+" does not exist");
        }
        employeeRepository.deleteById(emp_id);

    }


    public void updateEmployee(Long emp_id, String name, String email, String phonenumber, String username, String password) {
        Employee employee = employeeRepository.findById(emp_id)
                .orElseThrow(() -> new IllegalStateException("contractor with id "+emp_id+" does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(employee.getName(), name)){
            employee.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(employee.getEmail(), email)){
            employee.setEmail(email);
        }

        if (phonenumber != null && phonenumber.length() > 0 && !Objects.equals(employee.getPhonenumber(), phonenumber)){
            employee.setPhonenumber(phonenumber);
        }

        if (username != null && username.length() > 0 && !Objects.equals(employee.getUsername(), username)){
            Optional<Employee> employeeOptional = employeeRepository.findEmployeeByUsername(username);

            if (employeeOptional.isPresent()){
                throw new IllegalStateException("username exists");
            }

            employee.setUsername(username);
        }

        if (password != null && password.length() > 0 && !Objects.equals(employee.getPassword(), password)){
            employee.setPassword(password);
        }
    }
}
