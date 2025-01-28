package com.zuzex.education.service;

import com.zuzex.education.model.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<Car> getAll();

    Car get(UUID id);

    Car create(Car car);

    Car update(Car car);

    void delete(UUID id);
}
