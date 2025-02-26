package com.zuzex.education.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@NamedQuery(
        name = "Car.findAllByOwner",
        query = "FROM Car c WHERE c.ownerId = :ownerId"
)
@Entity
@Table(name = "cars")
public class Car {
    @Id
    private UUID id;

    @Column(name = "brand", length = 9, nullable = false)
    private String brand;

    @Column(name = "model", length = 9, nullable = false)
    private String model;

    @Column(name = "color", length = 15, nullable = false)
    private String color;

    @Column(name = "owner_id", nullable = false)
    private UUID ownerId;
}
