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
@Table(name = "people")
public class Person {
    @Id
    private UUID id;

    @Column(name =  "height", nullable = false)
    private Integer height;

    @Column(name =  "weight", nullable = false)
    private Integer weight;

    @Column(name =  "hair_color",length = 15, nullable = false)
    private String hairColor;
}
