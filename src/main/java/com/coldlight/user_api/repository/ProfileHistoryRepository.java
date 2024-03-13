package com.coldlight.user_api.repository;

import com.coldlight.user_api.model.ProfileHistory;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileHistoryRepository extends R2dbcRepository<ProfileHistory, Long> {
}
