package com.example.RestLocation.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantNotFoundExceptionTest {

    @Test
    void shouldCreateExceptionWithMessage() {

        String message = "Restaurant not found";

        RestaurantNotFoundException exception =
                new RestaurantNotFoundException(message);

        assertEquals(message, exception.getMessage());
    }
}