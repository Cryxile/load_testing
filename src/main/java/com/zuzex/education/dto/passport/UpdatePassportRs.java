package com.zuzex.education.dto.passport;

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
public class UpdatePassportRs {
    private UUID id;

    private String firstName;

    private String lastName;

    private UUID addressId;
}
