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
@Table(name = "individuals")
public class Individuals extends BaseEntity {


    @Column(name = "user_id", unique = true)
    private UUID userId;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "passport_number", length = 32)
    private String passportNumber;

    @Column(name = "phone_number", length = 32)
    private String phoneNumber;

    @Column(name = "email", length = 32)
    private String email;

    @Column(name = "verified_at", nullable = false)
    private LocalDateTime verifiedAt;

    @Column(name = "archived_at", nullable = false)
    private LocalDateTime archivedAt;

    @Column(name = "status", length = 32)
    private String status;

    @Transient
    private Users users;
}
