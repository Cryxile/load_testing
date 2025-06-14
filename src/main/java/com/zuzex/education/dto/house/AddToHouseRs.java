package com.zuzex.education.dto.house;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;
import java.util.UUID;

@Getter
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AddToHouseRs {
    private Set<UUID> houseOwners;
}
