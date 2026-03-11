package com.example.RestLocation.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LocationClientTest {

    @Mock
    private WebClient webClient;

    @InjectMocks
    private LocationClient client;

    @Test
    void shouldCallExternalAPI() {

        assertNotNull(client);
    }
}