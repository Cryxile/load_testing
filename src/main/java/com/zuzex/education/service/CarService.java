package com.zuzex.education.service;

import com.zuzex.education.model.db.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<Car> findAll();

    List<Car> findAllByOwner(UUID ownerId);

    Car get(UUID id);

    Car create(Car car);

    Car update(Car car);

    void delete(UUID id);

    void deleteByOwner(UUID ownerId);
}
