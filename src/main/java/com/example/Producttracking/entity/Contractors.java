package com.example.Producttracking.entity;
import javax.persistence.*;


@Entity
@Table
public class Contractors {
    @Id
    @GeneratedValue
    private Long contractor_id;
    private String name;
    private String email;
    private String phonenumber;
    private String username;
    private String password;

    public Contractors() {
    }

    public Contractors(Long contractor_id, String name, String email, String phonenumber, String username, String password) {
        this.contractor_id = contractor_id;
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
    }

    public Contractors(String name, String email, String phonenumber, String username, String password) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
    }

    public Long getContractor_id() {
        return contractor_id;
    }

    public void setContractor_id(Long contractor_id) {
        this.contractor_id = contractor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Contractors{" +
                "contractor_id=" + contractor_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
