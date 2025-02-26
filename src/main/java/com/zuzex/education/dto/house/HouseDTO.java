package com.zuzex.education.dto.house;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
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
public class HouseDTO {
    @NotNull
    private UUID id;

    @NotBlank
    @Size(min = 1, max = 9)
    private String wallMaterial;

    @NotNull
    @PastOrPresent
    private LocalDate buildDate;

    @NotNull
    private Boolean hasGasSupply;

    @NotNull
    private UUID addressId;
}
