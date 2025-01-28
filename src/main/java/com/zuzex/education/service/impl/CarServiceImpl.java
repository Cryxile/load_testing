package com.zuzex.education.service.impl;

import com.zuzex.education.exception.CarNotFoundException;
import com.zuzex.education.model.Car;
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
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car get(UUID id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
    }

    @Override
    public Car create(Car car) {
        return carRepository.save(
                car.toBuilder()
                        .id(UUID.randomUUID())
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
}
