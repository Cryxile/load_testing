package com.zuzex.education.dto.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CarDTO {
    @NotNull
    private UUID id;

    @NotNull
    private UUID ownerId;

    @NotBlank
    @Size(min = 3, max = 9)
    private String brand;

    @NotBlank
    @Size(min = 2, max = 9)
    private String model;

    @NotBlank
    @Size(min = 3, max = 15)
    private String color;
}
