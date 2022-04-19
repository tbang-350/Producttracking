package com.example.Producttracking.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long Contractor_id;
    private String name;
    private String gender;
    private String email;
    private String phonenumber;
    private String username;
    private String password;
}
