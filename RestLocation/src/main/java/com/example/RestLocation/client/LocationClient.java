package com.example.RestLocation.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Component
public class LocationClient {

    @Autowired
    private WebClient webClient;

    public List getLocationFromAPI(String restaurant){

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("q", restaurant + " india")
                        .queryParam("format","json")
                        .queryParam("limit",1)
                        .build())
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }
}