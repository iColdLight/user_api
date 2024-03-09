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
@Table(name = "profile_history")
public class ProfileHistory extends BaseEntity {

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "profile_id")
    //User ID
    private UUID profileId;

    @Column(name = "profile_type", length = 32)
    private String profileType;

    @Column(name = "reason", length = 255)
    private String reason;

    @Column(name = "comment", length = 255)
    private String comment;

    @Column(name = "changed_values", length = 1024)
    private String changedValues;

    @Transient
    private Users users;
}
