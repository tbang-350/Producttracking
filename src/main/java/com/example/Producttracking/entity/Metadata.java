package com.example.Producttracking.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.n52.jackson.datatype.jts.GeometryDeserializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;
import org.postgis.Point;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table
public class Metadata implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long meta_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;
    private LocalDate date;
    private LocalTime time;

    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    private Point location;

    public Metadata() {
    }

    public Metadata(Long meta_id, Employee employee, LocalDate date, LocalTime time, Point location) {
        this.meta_id = meta_id;
        this.employee = employee;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public Metadata(Employee employee, LocalDate date, LocalTime time, Point location) {
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "meta_id=" + meta_id +
                ", employee=" + employee +
                ", date=" + date +
                ", time=" + time +
                ", location=" + location +
                '}';
    }
}
