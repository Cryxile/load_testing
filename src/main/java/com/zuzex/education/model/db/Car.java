package com.zuzex.education.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
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
        query = "FROM Car c WHERE c.owner.id = :ownerId"
)
@NamedEntityGraph(
        name = "Car.owner",
        attributeNodes = @NamedAttributeNode("owner")
)
@Entity
@Table(name = "cars")
public class Car {
    @Id
    private UUID id;

    @Column(length = 9, nullable = false)
    private String brand;

    @Column(length = 9, nullable = false)
    private String model;

    @Column(length = 15, nullable = false)
    private String color;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    private Person owner;
}
