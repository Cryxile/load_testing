package com.zuzex.education.controller.impl;

import com.zuzex.education.controller.CarController;
import com.zuzex.education.dto.car.CarDTO;
import com.zuzex.education.dto.car.CreateCarRq;
import com.zuzex.education.dto.car.CreateCarRs;
import com.zuzex.education.dto.car.FindCarsRs;
import com.zuzex.education.mapper.CarMapper;
import com.zuzex.education.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CarControllerImpl implements CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    @Override
    public FindCarsRs findAll() {
        return carMapper.map(carService.findAll());
    }

    @Override
    public FindCarsRs findAllByOwner(UUID id) {
        return carMapper.map(carService.findAllByOwner(id));
    }

    @Override
    public CarDTO get(UUID id) {
        return carMapper.map(carService.get(id));
    }

    @Override
    public CreateCarRs create(CreateCarRq car) {
        return carMapper.mapRs(
                carService.create(
                        carMapper.map(car)
                )
        );
    }

    @Override
    public CarDTO update(CarDTO car) {
        return carMapper.map(
                carService.update(
                        carMapper.map(car)
                )
        );
    }

    @Override
    public void delete(UUID id) {
        carService.delete(id);
    }
}
