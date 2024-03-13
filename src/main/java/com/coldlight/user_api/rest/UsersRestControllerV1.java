package com.coldlight.user_api.rest;

import com.coldlight.user_api.model.Users;
import com.coldlight.user_api.model.VerificationStatuses;
import com.coldlight.user_api.service.UsersService;
import com.coldlight.user_api.service.VerificationStatusesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersRestControllerV1 {

    private final UsersService usersService;

    private final VerificationStatusesService verificationStatusesService;

    @PostMapping
    public Mono<ResponseEntity<Users>> saveUser(@RequestBody Users user) {
        return usersService.save(user)
                .flatMap(savedUser -> {
                    UUID userId = savedUser.getId();
                    return verificationStatusesService.createUserWithVerificationStatus(userId)
                            .thenReturn(savedUser);
                })
                .map(savedUser -> new ResponseEntity<>(savedUser, HttpStatus.CREATED))
                .onErrorResume(error -> Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)));
    }

    @PutMapping("/{userId}/update-verification-status")
    public Mono<ResponseEntity<VerificationStatuses>> updateVerificationStatus(
            @PathVariable UUID userId,
            @RequestParam String status) {
        return verificationStatusesService.updateUserVerificationStatus(userId, status)
                .map(updatedStatus -> new ResponseEntity<>(updatedStatus, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND))
                .onErrorResume(error -> Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)));
    }

    @GetMapping("/{userId}")
    public Mono<ResponseEntity<Users>> getUserById(@PathVariable("userId") UUID id) {
        return usersService.getById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND))
                .onErrorResume(error -> Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)));
    }

    @GetMapping
    public Flux<ResponseEntity<Users>> getAllUsers() {
        return usersService.getAll()
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .onErrorResume(error -> Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)));
    }

    @DeleteMapping("/{userId}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable("userId") UUID id) {
        return usersService.delete(id)
                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                .onErrorResume(error -> Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)));
    }
}
