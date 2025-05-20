package com.pe.placeroutes.client;

import com.pe.placeroutes.common.Constant;
import com.pe.placeroutes.external.weather.WeatherResponse;
import com.pe.placeroutes.service.cache.ReactiveCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class WeatherClient {

    private final WebClient            webClient;
    private final ReactiveCacheService cacheService;

    public Mono<WeatherResponse> getWeatherByCity(String city) {
        String key = Constant.WEATHER_HASH_KEY.concat(city);
        return cacheService.getWeather(key)
                .switchIfEmpty(getWeather(city)
                        .flatMap(response -> cacheService.saveWeather(key, response, Duration.ofMinutes(1))
                                .thenReturn(response)));
    }

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
