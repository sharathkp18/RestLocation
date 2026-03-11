package com.example.RestLocation.service;

import com.example.RestLocation.client.LocationClient;
import com.example.RestLocation.exception.RestaurantNotFoundException;
import com.example.RestLocation.model.LocationResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RestaurantService {

    private final LocationClient client;

    public RestaurantService(LocationClient client) {
        this.client = client;
    }

    public LocationResponse getRestaurantLocation(String restaurant) {

        List<Map<String, String>> response = client.getLocationFromAPI(restaurant);

        Map<String, String> place = response.stream().findFirst().orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));

        double lat = Double.parseDouble(place.get("lat"));
        double lon = Double.parseDouble(place.get("lon"));

        return new LocationResponse(restaurant, lat, lon);
    }
}