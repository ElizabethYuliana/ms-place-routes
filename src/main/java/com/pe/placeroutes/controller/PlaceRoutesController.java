package com.pe.placeroutes.controller;

import com.pe.placeroutes.model.PlaceRoutesRequest;
import com.pe.placeroutes.model.PlaceRoutesResponse;
import com.pe.placeroutes.service.IPlaceRoutesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/route")
@RequiredArgsConstructor
public class PlaceRoutesController {
    private final IPlaceRoutesService placeRoutesService;

    @PostMapping("/information")
    public Mono<ResponseEntity<PlaceRoutesResponse>> getInformationRoute(@RequestBody PlaceRoutesRequest request) {
        return placeRoutesService.getInformationRoute(request)
            .map(ResponseEntity::ok)
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
