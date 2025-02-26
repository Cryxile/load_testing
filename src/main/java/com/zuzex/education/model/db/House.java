package com.zuzex.education.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@Table(name = "houses")
public class House {
    @Id
    private UUID id;

    @Column(name = "wall_material", length = 9, nullable = false)
    private String wallMaterial;

    @Column(name = "build_date", nullable = false)
    private LocalDate buildDate;

    @Column(name = "has_gas_supply", nullable = false)
    private Boolean hasGasSupply;

    @Column(name = "address_id", nullable = false, updatable = false)
    private UUID addressId;
}
