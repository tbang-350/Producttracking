package com.example.Producttracking.dto;

import lombok.Data;

@Data
public class GetEmployeeDto {
    private Long emp_id;
    private Long Contractor_id;
    private String name;
    private String gender;
    private String email;
    private String phonenumber;
}
