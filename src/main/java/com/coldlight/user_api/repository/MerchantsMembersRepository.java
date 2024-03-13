package com.coldlight.user_api.repository;

import com.coldlight.user_api.model.MerchantsMembers;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantsMembersRepository extends R2dbcRepository<MerchantsMembers, Long> {
}
