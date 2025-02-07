package com.zuzex.education.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    @Column(length = 15, nullable = false)
    private String firstName;

    @Column(length = 15, nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(length = 6, nullable = false)
    private String gender;

    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Person owner;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address residentAddress;
}
