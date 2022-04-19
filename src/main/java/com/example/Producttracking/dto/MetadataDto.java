package com.example.Producttracking.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.n52.jackson.datatype.jts.GeometryDeserializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;
import org.postgis.Point;
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
