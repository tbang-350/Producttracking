package com.example.Producttracking.dto;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.postgis.Point;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class MetadataDto {
    private Long emp_id;
    private LocalDate date;
    private LocalTime time;

    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    private Point location;
}
