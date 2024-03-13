package com.coldlight.user_api.service.impl;

import com.coldlight.user_api.model.Users;
import com.coldlight.user_api.repository.UsersRepository;
import com.coldlight.user_api.service.UsersService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Mono<Users> save(Users users) {
        return usersRepository.save(users);

    }

    @Override
    public Mono<Void> delete(UUID id) {
        return usersRepository.deleteById(id)
                .switchIfEmpty(Mono.error(new Throwable("User is not found")));
    }

    @Override
    public Flux<Users> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public Mono<Users> getById(UUID id) {
        return usersRepository.findById(id)
                .switchIfEmpty(Mono.error(new Throwable("User is not found")));
    }
}
