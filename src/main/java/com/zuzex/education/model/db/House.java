package com.zuzex.education.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@Table(name = "houses")
public class House {
    @Id
    private UUID id;

    @Column(length = 9, nullable = false)
    private String wallMaterial;

    @Column(nullable = false)
    private LocalDate buildDate;

    @Column(nullable = false)
    private Boolean hasGasSupply;

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false, updatable = false)
    private Address address;

    @ManyToMany
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "people_houses",
            joinColumns = @JoinColumn(name = "house_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false))
    private Set<Person> owners;
}
