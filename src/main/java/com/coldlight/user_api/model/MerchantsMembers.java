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
@Table(name = "merchant_members")
public class MerchantsMembers extends BaseEntity {

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "merchant_id")
    private UUID merchant;

    @Column(name = "member_role", length = 32)
    private String memberRole;

    @Column(name = "status", length = 32)
    private String status;

    @Transient
    private Users users;

    @Transient
    private Merchants merchants;
}
