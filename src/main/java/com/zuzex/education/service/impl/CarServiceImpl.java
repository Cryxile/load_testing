package com.zuzex.education.service.impl;

import com.zuzex.education.exception.CarNotFoundException;
import com.zuzex.education.model.db.Car;
import com.zuzex.education.repository.CarRepository;
import com.zuzex.education.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findAllByOwner(UUID ownerId) {
        return carRepository.findAllByOwner(ownerId);
    }

    @Override
    public Car get(UUID id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
    }

    @Override
    public Car create(Car car) {
        return carRepository.save(
                Car.builder()
                        .id(UUID.randomUUID())
                        .brand(car.getBrand())
                        .model(car.getModel())
                        .color(car.getColor())
                        .owner(car.getOwner())
                        .build()
        );
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(UUID id) {
        carRepository.deleteById(id);
    }

    @Override
    public void deleteByOwner(UUID ownerId) {
        carRepository.deleteByOwner(ownerId);
    }
}
