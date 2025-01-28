package com.zuzex.education.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.extern.jackson.Jacksonized;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;

import java.sql.Date;
import java.util.UUID;

@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class HouseDTO {
    private UUID id;

    @NotBlank
    @Size(min = 1, max = 9)
    private String wallMaterial;

    @NotBlank
    @PastOrPresent
    private Date buildDate;

    private Boolean hasGasSupply;

    private UUID addressId;
}
