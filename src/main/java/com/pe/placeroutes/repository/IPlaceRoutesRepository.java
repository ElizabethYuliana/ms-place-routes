package com.pe.placeroutes.repository;

import com.pe.placeroutes.entity.PlaceRoutes;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IPlaceRoutesRepository extends ReactiveMongoRepository<PlaceRoutes, String> {

    Mono<PlaceRoutes> findByOriginAndDestinationAndTransport(String origin, String destination, String transport);
}
