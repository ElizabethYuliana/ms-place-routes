package com.pe.placeroutes.model;

import com.pe.placeroutes.external.weather.WeatherResponse;
import lombok.Data;


@Data
public class PlaceRoutesResponse {
    private String          origin;
    private String          destination;
    private String          transport;
    private String          distance;
    private String          time;
    private WeatherResponse destinationWeather;
}
