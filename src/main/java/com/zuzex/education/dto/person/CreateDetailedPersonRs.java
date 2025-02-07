package com.zuzex.education.dto.person;

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
public class CreateDetailedPersonRs {
    private UUID id;

    private Integer height;

    private Integer weight;

    private String hairColor;

    private UUID passportId;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String gender;

    private UUID addressId;
}
