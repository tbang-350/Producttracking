package com.example.Producttracking.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table
public class Metadata {

    @Id
    @GeneratedValue
    private Long meta_id;

    @ManyToOne(targetEntity = Employee.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private int emp_id;
    private LocalDate date;
    private LocalTime time;
    private BigInteger location;

    public Metadata() {
    }

    public Metadata(Long meta_id, int emp_id, LocalDate date, LocalTime time, BigInteger location) {
        this.meta_id = meta_id;
        this.emp_id = emp_id;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public Metadata(int emp_id, LocalDate date, LocalTime time, BigInteger location) {
        this.emp_id = emp_id;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public Long getMeta_id() {
        return meta_id;
    }

    public void setMeta_id(Long meta_id) {
        this.meta_id = meta_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigInteger getLocation() {
        return location;
    }

    public void setLocation(BigInteger location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "meta_id=" + meta_id +
                ", emp_id=" + emp_id +
                ", date=" + date +
                ", time=" + time +
                ", location=" + location +
                '}';
    }
}
