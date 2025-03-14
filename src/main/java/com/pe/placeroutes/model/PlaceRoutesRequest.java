package com.pe.placeroutes.model;

import lombok.Data;

@Data
public class PlaceRoutesRequest {

    private String origin;
    private String destination;
    private String transport;
}
