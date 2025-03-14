package com.pe.placeroutes.external.weather;

import lombok.Data;

@Data
public class WeatherResponse {
    private String city;
    private String country;
    private String weather;
    private String temperature;
    private String humidity;
}
