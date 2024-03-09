package com.coldlight.user_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "countries")
public class Countries extends BaseEntity {

    @CreatedDate
    @Column(name = "created")
    private LocalDateTime created;

    @LastModifiedDate
    @Column(name = "updated")
    private LocalDateTime updated;

    @Column(name = "name", length = 32)
    private String name;

    @Column(name = "alpha2", length = 2)
    private String alpha2;

    @Column(name = "alpha3", length = 3)
    private String alpha3;

    @Column(name = "status", length = 32)
    private String status;

}
