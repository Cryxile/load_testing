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
public class CarDTO {
    private UUID id;

    private UUID personId;

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
