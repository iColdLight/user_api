package com.coldlight.user_api.repository;

import com.coldlight.user_api.model.Merchants;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantsRepository extends R2dbcRepository<Merchants, Long> {
}
