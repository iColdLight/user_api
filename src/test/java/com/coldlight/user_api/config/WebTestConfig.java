package com.coldlight.user_api.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.context.WebApplicationContext;

//@Configuration
public class WebTestConfig {

    @Bean
    public WebTestClient webTestClient(WebApplicationContext applicationContext) {
        return WebTestClient.bindToApplicationContext(applicationContext).build();
    }
}
