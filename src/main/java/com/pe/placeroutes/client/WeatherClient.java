package com.pe.placeroutes.client;

import com.pe.placeroutes.external.weather.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class WeatherClient {

    private final WebClient webClient;

    public Mono<WeatherResponse> getWeather(String city) {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather/city")
                        .queryParam("city", city)
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class);
    }
}
