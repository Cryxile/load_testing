package com.zuzex.education.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@Table(name = "people")
public class Person {
    @Id
    private UUID id;

    @Column(nullable = false)
    private Integer height;

    @Column(nullable = false)
    private Integer weight;

    @Column(length = 15, nullable = false)
    private String hairColor;

    @ManyToMany
    @JoinTable(name = "people_houses",
            joinColumns = @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "house_id", referencedColumnName = "id", nullable = false))
    private Set<House> houses;
}
