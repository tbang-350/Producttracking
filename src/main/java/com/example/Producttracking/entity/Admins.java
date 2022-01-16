package com.example.Producttracking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Admins {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
}
