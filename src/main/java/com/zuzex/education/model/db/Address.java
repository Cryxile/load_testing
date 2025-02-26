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

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    private UUID id;

    @Column(name = "city", length = 100, nullable = false)
    private String city;

    @Column(name = "street",length = 150, nullable = false)
    private String street;

    @Column(name = "house_number",length = 6, nullable = false)
    private String houseNumber;
}
