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

@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreateHouseRq {
    @NotBlank
    @Size(min = 1, max = 9)
    private String wallMaterial;

    @NotNull
    @PastOrPresent
    private LocalDate buildDate;

    @NotNull
    private Boolean hasGasSupply;

    @NotBlank
    @Size(min = 3, max = 100)
    private String city;

    @NotBlank
    @Size(min = 3, max = 150)
    private String street;

    @NotBlank
    @Size(min = 1, max = 6)
    private String houseNumber;
}
