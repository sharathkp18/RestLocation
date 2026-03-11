package com.example.RestLocation.controller;

import com.example.RestLocation.exception.RestaurantNotFoundException;
import com.example.RestLocation.model.LocationResponse;
import com.example.RestLocation.service.RestaurantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class RestaurantControllerTest {

    @Mock
    private RestaurantService service;

    @InjectMocks
    private RestaurantController controller;

    @Test
    void shouldReturnLocation() {

        LocationResponse response = new LocationResponse("pizza hut bangalore", 12.97, 77.59);

        Mockito.when(service.getRestaurantLocation("pizza hut bangalore")).thenReturn(response);

        LocationResponse result = controller.getLocation("pizza hut bangalore");

        assertEquals("pizza hut bangalore", result.getRestaurant());
        assertEquals(12.97, result.getLatitude());
        assertEquals(77.59, result.getLongitude());
    }

    @Test
    void shouldThrowExceptionWhenRestaurantNotFound() {

        Mockito.when(service.getRestaurantLocation(Mockito.anyString())).thenThrow(new RestaurantNotFoundException("Restaurant not found"));

        assertThrows(RestaurantNotFoundException.class, () -> controller.getLocation("unknown"));
    }
}