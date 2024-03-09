package com.coldlight.user_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "merchant_members_invitations")
public class MerchantMembersInvitations extends BaseEntity {

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "expires", nullable = false)
    private LocalDateTime expires;

    @Column(name = "merchant_id")
    private UUID merchantId;

    @Column(name = "first_name", length = 32)
    private String firstName;

    @Column(name = "last_name", length = 32)
    private String lastName;

    @Column(name = "email", length = 32)
    private String email;

    @Column(name = "status", length = 32)
    private String status;

    @Transient
    private Merchants merchants;
}
