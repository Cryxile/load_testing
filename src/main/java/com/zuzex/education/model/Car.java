package com.zuzex.education.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@Table(name = "cars")
public class Car {
    @Id
    private UUID id;

    private String brand;

    private String model;

    private String color;

    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Person owner;
}
