package com.example.RestLocation.controller;

import com.example.RestLocation.model.LocationResponse;
import com.example.RestLocation.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping("/location")
    public LocationResponse getLocation(@RequestParam String name) {
        return service.getRestaurantLocation(name);
    }
}