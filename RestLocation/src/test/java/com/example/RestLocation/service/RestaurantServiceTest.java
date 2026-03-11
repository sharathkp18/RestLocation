package com.example.RestLocation.service;

import com.example.RestLocation.client.LocationClient;
import com.example.RestLocation.exception.RestaurantNotFoundException;
import com.example.RestLocation.model.LocationResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {

    @Mock
    private LocationClient client;

    @InjectMocks
    private RestaurantService service;

    @Test
    void shouldReturnLocationWhenRestaurantExists() {

        Map<String, String> place = Map.of("lat", "12.29", "lon", "76.63");
        List<Map<String, String>> response = List.of(place);

        Mockito.when(client.getLocationFromAPI(Mockito.anyString())).thenReturn(response);

        LocationResponse result = service.getRestaurantLocation("KFC Mysuru");

        assertEquals("KFC Mysuru", result.getRestaurant());
        assertEquals(12.29, result.getLatitude());
        assertEquals(76.63, result.getLongitude());
    }

    @Test
    void shouldThrowExceptionWhenRestaurantNotFound() {

        Mockito.when(client.getLocationFromAPI(Mockito.anyString())).thenReturn(Collections.emptyList());

        assertThrows(RestaurantNotFoundException.class, () -> service.getRestaurantLocation("unknown"));
    }
}