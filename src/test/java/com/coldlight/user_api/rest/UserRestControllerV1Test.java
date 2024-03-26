package com.coldlight.user_api.rest;

import com.coldlight.user_api.config.WebTestConfig;
import com.coldlight.user_api.model.Users;
import com.coldlight.user_api.service.UsersService;
import com.coldlight.user_api.service.VerificationStatusesService;
import com.coldlight.user_api.support.DataSourceStub;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.when;

//@SpringJUnitConfig

@SpringBootTest
@ActiveProfiles(profiles = "test")
@Import(DataSourceStub.class)
//@ContextConfiguration(classes = {WebTestConfig.class})
@AutoConfigureWebTestClient
//@Testcontainers
public class UserRestControllerV1Test {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    @Sql({"/mock_data.sql"})
    public void testGetUserById_ExistingUser() {
        webTestClient.get()
                .uri("/api/v1/users/3cafd4a0-b739-4568-a421-3d4c31d990e6")
                .exchange()
                .expectStatus().isOk()
                .returnResult(Users.class);
        System.out.println("Result");
    }

/*    @Test
    public void testGetUserById_NonexistentUser() {
        UUID userId = UUID.randomUUID();

        when(usersService.getById(userId)).thenReturn(Mono.empty());

        webTestClient.get()
                .uri("/users/" + userId)
                .exchange()
                .expectStatus().isNotFound();
    }*/
}
