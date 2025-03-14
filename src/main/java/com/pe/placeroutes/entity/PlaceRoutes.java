package com.pe.placeroutes.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "routes")
public class PlaceRoutes {
    @Id
    private String id;
    @Field
    private String origin;
    @Field
    private String destination;
    @Field
    private String transport;
    @Field
    private String distance;
    @Field
    private String time;

}
