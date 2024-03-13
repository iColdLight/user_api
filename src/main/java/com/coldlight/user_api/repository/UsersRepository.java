package com.coldlight.user_api.repository;

import com.coldlight.user_api.model.Users;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UsersRepository extends R2dbcRepository<Users, UUID> {
}
