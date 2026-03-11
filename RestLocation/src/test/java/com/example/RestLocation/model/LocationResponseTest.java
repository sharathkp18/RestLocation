package com.example.RestLocation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationResponseTest {

    @Test
    void shouldCreateLocationResponse() {

        LocationResponse response =
                new LocationResponse("KFC",12.29,76.63);

        assertEquals("KFC", response.getRestaurant());
        assertEquals(12.29, response.getLatitude());
        assertEquals(76.63, response.getLongitude());
    }
}