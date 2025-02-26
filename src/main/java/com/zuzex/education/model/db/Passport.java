package com.zuzex.education.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "passports")
public class Passport {
    @Id
    private UUID id;

    @Column(name =  "first_name",length = 15, nullable = false)
    private String firstName;

    @Column(name =  "last_name",length = 15, nullable = false)
    private String lastName;

    @Column(name =  "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name =  "gender", length = 6, nullable = false)
    private String gender;

    @Column(name = "owner_id", nullable = false)
    private UUID ownerId;

    @Column(name = "address_id", nullable = false)
    private UUID residentAddressId;
}
