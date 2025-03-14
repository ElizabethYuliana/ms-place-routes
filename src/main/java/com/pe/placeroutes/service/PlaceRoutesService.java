package com.pe.placeroutes.service;

import com.pe.placeroutes.client.WeatherClient;
import com.pe.placeroutes.entity.PlaceRoutes;
import com.pe.placeroutes.external.weather.WeatherResponse;
import com.pe.placeroutes.model.PlaceRoutesRequest;
import com.pe.placeroutes.model.PlaceRoutesResponse;
import com.pe.placeroutes.repository.IPlaceRoutesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlaceRoutesService implements IPlaceRoutesService {

    private final IPlaceRoutesRepository placeRoutesRepository;
    private final WeatherClient          weatherClient;

    @Override
    public Mono<PlaceRoutesResponse> getInformationRoute(PlaceRoutesRequest request) {
        Mono<PlaceRoutes> placeRoutes = placeRoutesRepository.findByOriginAndDestinationAndTransport(request.getOrigin(),
                request.getDestination(), request.getTransport());
        return placeRoutes.flatMap(placeRoute -> weatherClient.getWeather(placeRoute.getDestination())
            .map(weatherResponse -> buildResponse(placeRoute, weatherResponse)));
    }

    private PlaceRoutesResponse buildResponse(PlaceRoutes placeRoute, WeatherResponse weatherResponse) {
        PlaceRoutesResponse response = new PlaceRoutesResponse();
        response.setOrigin(placeRoute.getOrigin());
        response.setDestination(placeRoute.getDestination());
        response.setTransport(placeRoute.getTransport());
        response.setDistance(placeRoute.getDistance());
        response.setTime(placeRoute.getTime());
        response.setDestinationWeather(weatherResponse);
        return response;
    }
}
