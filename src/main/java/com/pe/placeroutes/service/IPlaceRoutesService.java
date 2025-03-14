package com.pe.placeroutes.service;

import com.pe.placeroutes.model.PlaceRoutesRequest;
import com.pe.placeroutes.model.PlaceRoutesResponse;
import reactor.core.publisher.Mono;

public interface IPlaceRoutesService {

    Mono<PlaceRoutesResponse> getInformationRoute(PlaceRoutesRequest placeRoutes);
}
