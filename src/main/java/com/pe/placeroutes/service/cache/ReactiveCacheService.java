package com.pe.placeroutes.service.cache;

import com.pe.placeroutes.common.Utils;
import com.pe.placeroutes.external.weather.WeatherResponse;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ReactiveCacheService {
    private final ReactiveValueOperations<String, String> valueOperations;

    public ReactiveCacheService(ReactiveRedisTemplate<String, String> redisTemplate) {
        this.valueOperations = redisTemplate.opsForValue();
    }

    public Mono<Boolean> saveWeather(String key, WeatherResponse response, Duration ttl) {
        return valueOperations.set(key, Utils.toJson(response), ttl);
    }

    public Mono<WeatherResponse> getWeather(String key) {
        return valueOperations.get(key)
                .map(w -> Utils.fromJson(w, WeatherResponse.class));
    }


}
