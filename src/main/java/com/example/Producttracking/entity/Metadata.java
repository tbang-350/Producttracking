package com.example.Producttracking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.postgis.Point;
import org.locationtech.jts.geom.Geometry;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metadata implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue()
    private Long meta_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;

    private Geometry coord;


    public Metadata(Employee employee, Geometry coord) {
        this.employee = employee;
        this.coord = coord;
    }
}
