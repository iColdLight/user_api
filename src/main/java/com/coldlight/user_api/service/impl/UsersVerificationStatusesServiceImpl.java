package com.coldlight.user_api.service.impl;

import com.coldlight.user_api.model.VerificationStatuses;
import com.coldlight.user_api.repository.VerificationStatusesRepository;
import com.coldlight.user_api.service.VerificationStatusesService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UsersVerificationStatusesServiceImpl implements VerificationStatusesService {

    private final VerificationStatusesRepository verificationStatusesRepository;


    public UsersVerificationStatusesServiceImpl(VerificationStatusesRepository verificationStatusesRepository) {
        this.verificationStatusesRepository = verificationStatusesRepository;
    }
    @Override
    public Mono<VerificationStatuses> createUserWithVerificationStatus(UUID userId) {
        VerificationStatuses verificationStatus = VerificationStatuses.builder()
                .created(LocalDateTime.now())
                .profileId(userId)
                .profileType("User profile type")
                .details("User details")
                .verificationStatus("Verified")
                .build();

        return verificationStatusesRepository.save(verificationStatus);
    }

    @Override
    public Mono<VerificationStatuses> updateUserVerificationStatus(UUID userId, String newVerificationStatus) {
        return verificationStatusesRepository.findById(userId)
                .flatMap(verificationStatus -> {
                    verificationStatus.setVerificationStatus(newVerificationStatus);
                    verificationStatus.setUpdated(LocalDateTime.now());
                    return verificationStatusesRepository.save(verificationStatus);
                });
    }
}
