package com.coldlight.user_api.repository;

import com.coldlight.user_api.model.Addresses;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends R2dbcRepository<Addresses, Long> {
}
