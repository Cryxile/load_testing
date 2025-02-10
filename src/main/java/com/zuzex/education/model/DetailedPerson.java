package com.zuzex.education.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class DetailedPerson {
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
