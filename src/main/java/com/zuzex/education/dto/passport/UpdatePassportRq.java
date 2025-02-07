package com.zuzex.education.dto.passport;

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
public class UpdatePassportRq {
    @NotNull
    private UUID id;

    @NotBlank
    @Size(min = 2, max = 15)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 15)
    private String lastName;

    @NotNull
    private UUID addressId;
}
