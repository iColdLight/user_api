package com.coldlight.user_api.repository;

import com.coldlight.user_api.model.MerchantMembersInvitations;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantMembersInvitationsRepository extends R2dbcRepository<MerchantMembersInvitations, Long> {
}
