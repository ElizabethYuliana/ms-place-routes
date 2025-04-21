package com.pe.placeroutes.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class WebClientConfiguration {

    @Value("${api.weather}")
    private String apiWeather;

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .baseUrl(apiWeather)
                .build();
    }
}
