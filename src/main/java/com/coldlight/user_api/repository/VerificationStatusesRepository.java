package com.coldlight.user_api.repository;

import com.coldlight.user_api.model.VerificationStatuses;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface VerificationStatusesRepository extends R2dbcRepository<VerificationStatuses, UUID> {
}
