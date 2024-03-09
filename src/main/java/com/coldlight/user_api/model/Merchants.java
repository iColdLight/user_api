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
@Table(name = "merchants")
public class Merchants extends BaseEntity {

    @Column(name = "creator_id")
    //User ID
    private UUID creatorId;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "company_name", length = 32)
    private String companyName;

    @Column(name = "company_id", length = 32)
    private String companyId;

    @Column(name = "email", length = 32)
    private String email;

    @Column(name = "phone_number", length = 32)
    private String phoneNumber;

    @Column(name = "verified_at", nullable = false)
    private LocalDateTime verifiedAt;

    @Column(name = "archived_at", nullable = false)
    private LocalDateTime archivedAt;

    @Column(name = "status", length = 32)
    private String status;

    @Column(name = "filled")
    private boolean filled;

    @Transient
    private Users users;
}
