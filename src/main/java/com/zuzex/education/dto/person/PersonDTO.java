package com.zuzex.education.dto.person;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class PersonDTO {
    @NotNull
    private UUID id;

    @Max(200)
    @Min(20)
    private Integer height;

    @Max(200)
    @Min(5)
    private Integer weight;

    @NotBlank
    @Size(min = 3, max = 15)
    private String hairColor;
}
