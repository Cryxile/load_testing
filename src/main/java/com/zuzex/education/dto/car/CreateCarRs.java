package com.zuzex.education.dto.car;

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
public class CreateCarRs {
    private UUID id;

    private UUID ownerId;

    private String brand;

    private String model;

    private String color;
}
