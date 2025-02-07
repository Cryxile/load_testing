package com.zuzex.education.controller.impl;

import com.zuzex.education.controller.CarController;
import com.zuzex.education.dto.car.CarDTO;
import com.zuzex.education.dto.car.CreateCarRq;
import com.zuzex.education.dto.car.CreateCarRs;
import com.zuzex.education.dto.car.GetCarListRs;
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
    public GetCarListRs getAll() {
        return carMapper.map(carService.getAll());
    }

    @Override
    public GetCarListRs getAllByOwner(UUID id) {
        return carMapper.map(carService.getAllByOwner(id));
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
