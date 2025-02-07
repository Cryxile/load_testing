package com.zuzex.education.dto.house;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreateHouseRs {
    private UUID id;

    private String wallMaterial;

    private LocalDate buildDate;

    private Boolean hasGasSupply;

    private UUID addressId;

    private String city;

    private String street;

    private String houseNumber;
}
