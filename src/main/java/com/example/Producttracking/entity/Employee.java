package com.example.Producttracking.entity;
import javax.persistence.*;


@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue
    private Long emp_id;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name = "contractor_id", referencedColumnName = "contractor_id")
    private Contractors contractor;
    private String name;
    private String gender;
    private String email;
    private String phonenumber;
    private String username;
    private String password;

    public Employee() {
    }

    public Employee(Long emp_id, Contractors contractor, String name, String gender, String email, String phonenumber, String username, String password) {
        this.emp_id = emp_id;
        this.contractor= contractor;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
    }

    public Employee(Contractors contractor, String name, String gender, String email, String phonenumber, String username, String password) {
        this.contractor = contractor;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
    }

    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public Contractors getContractor() {
        return contractor;
    }

    public void setContractor_id(Contractors contractor) {
        this.contractor = contractor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        return "Employee{" +
                "emp_id=" + emp_id +
                ", contractor_id=" + contractor +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
