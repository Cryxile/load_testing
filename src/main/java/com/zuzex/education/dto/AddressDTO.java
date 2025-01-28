package com.zuzex.education.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.extern.jackson.Jacksonized;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;

import java.util.UUID;

@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AddressDTO {
    private UUID id;

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
