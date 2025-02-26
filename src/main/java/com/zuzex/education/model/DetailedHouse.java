package com.zuzex.education.model;

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
public class DetailedHouse {
    private UUID id;

    private String wallMaterial;

    private LocalDate buildDate;

    private Boolean hasGasSupply;

    private UUID addressId;

    private String city;

    private String street;

    private String houseNumber;
}
