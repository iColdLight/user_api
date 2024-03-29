package com.coldlight.user_api.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
@Table(name = "users")
public class Users extends BaseEntity {

    @Column(name = "secret_key", length = 32)
    private String secretKey;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "first_name", length = 32)
    public String firstName;

    @Column(name = "last_name", length = 32)
    private String lastName;

    @Column(name = "verified_at", nullable = false)
    private LocalDateTime verifiedAt;

    @Column(name = "archived_at", nullable = false)
    private LocalDateTime archivedAt;

    @Column(name = "status", length = 64)
    private String status;

    @Column(name = "filled")
    private boolean filled;

    @Column(name = "address_id")
    private UUID addressId;

    @Transient
    private Addresses addresses;


}
