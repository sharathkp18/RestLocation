package com.example.RestLocation.exception;

import com.example.RestLocation.controller.RestaurantController;
import com.example.RestLocation.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    private MockMvc mockMvc;

    @Mock
    private RestaurantService service;

    @InjectMocks
    private RestaurantController controller;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    void shouldReturn404WhenRestaurantNotFound() throws Exception {

        Mockito.when(service.getRestaurantLocation(Mockito.anyString()))
                .thenThrow(new RestaurantNotFoundException("Restaurant not found"));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/restaurant/location")
                        .param("name", "unknown"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Restaurant not found"));
    }

    @Test
    void shouldReturn500ForGenericException() throws Exception {

        Mockito.when(service.getRestaurantLocation(Mockito.anyString()))
                .thenThrow(new RuntimeException("Unexpected error"));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/restaurant/location")
                        .param("name", "pizza hut bangalore"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Internal Server Error"));
    }
    @Test
    void shouldReturnBadRequest() throws Exception {

        Mockito.when(service.getRestaurantLocation(Mockito.anyString()))
                .thenThrow(new IllegalArgumentException("Invalid restaurant name"));

        mockMvc.perform(get("/restaurant/location")
                        .param("name", ""))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid restaurant name"));
    }
    @Test
    void shouldReturnInternalServerErrorWhenNullPointerOccurs() throws Exception {

        Mockito.when(service.getRestaurantLocation(Mockito.anyString()))
                .thenThrow(new NullPointerException());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/restaurant/location")
                        .param("name", "pizza hut bangalore"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Unexpected null value occurred"));
    }
}