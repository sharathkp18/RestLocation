package com.example.RestLocation.client;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;

class WebClientConfigTest {

    @Test
    void shouldCreateWebClientBean(){

        WebClientConfig config = new WebClientConfig();
        WebClient client = config.webClient();

        assertNotNull(client);
    }
}