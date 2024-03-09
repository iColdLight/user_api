package com.coldlight.user_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "addresses")
public class Addresses extends BaseEntity {

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "countries")
    private Integer countryId;

    @Column(name = "address", length = 128)
    private String address;

    @Column(name = "zip_code", length = 32)
    private String zipCode;

    @Column(name = "archived", nullable = false)
    private LocalDateTime archived;

    @Column(name = "city", length = 32)
    private String city;

    @Column(name = "state", length = 32)
    private String state;

    @Transient
    private Countries countries;
}
