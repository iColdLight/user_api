package com.coldlight.user_api.service;

import com.coldlight.user_api.model.Users;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UsersService {

    Mono<Users> save (Users users);

    Mono<Void> delete(UUID id);

    Flux<Users> getAll();

    Mono<Users> getById(UUID id);
}
