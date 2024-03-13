package com.coldlight.user_api.repository;

import com.coldlight.user_api.model.Individuals;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualsRepository extends R2dbcRepository<Individuals, Long> {
}
