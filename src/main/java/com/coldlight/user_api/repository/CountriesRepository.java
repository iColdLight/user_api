package com.coldlight.user_api.repository;

import com.coldlight.user_api.model.Countries;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends R2dbcRepository<Countries, Long> {
}
