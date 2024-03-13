package com.coldlight.user_api.service;

import com.coldlight.user_api.model.VerificationStatuses;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface VerificationStatusesService {
    Mono<VerificationStatuses> createUserWithVerificationStatus(UUID userId);

    Mono<VerificationStatuses> updateUserVerificationStatus(UUID userId, String status);
}
