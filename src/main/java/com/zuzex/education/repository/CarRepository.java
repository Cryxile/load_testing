package com.zuzex.education.repository;

import com.zuzex.education.model.db.Car;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarRepository {
    List<Car> findAll();
    List<Car> findAllByOwner(UUID ownerId);
    Optional<Car> findById(UUID id);
    Car save(Car car);
    void deleteById(UUID id);
    void deleteByOwner(UUID id);
}
