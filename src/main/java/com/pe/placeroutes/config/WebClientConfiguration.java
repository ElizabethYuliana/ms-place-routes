package com.pe.placeroutes.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class WebClientConfiguration {

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build();
    }
}
