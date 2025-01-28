package com.zuzex.education.controller.impl;

import com.zuzex.education.controller.CarController;
import com.zuzex.education.dto.CarDTO;
import com.zuzex.education.mapper.CarMapper;
import com.zuzex.education.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CarControllerImpl implements CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    @Override
    public List<CarDTO> getAll() {
        return carMapper.mapCarToCarDto(carService.getAll());
    }

    @Override
    public CarDTO get(UUID id) {
        return carMapper.mapCarToCarDto(carService.get(id));
    }

    @Override
    public CarDTO create(CarDTO carDTO) {
        return carMapper.mapCarToCarDto(
                carService.create(carMapper.mapCarDtoToCar(carDTO))
        );
    }

    @Override
    public CarDTO update(CarDTO carDTO) {
        return carMapper.mapCarToCarDto(
                carService.update(carMapper.mapCarDtoToCar(carDTO))
        );
    }

    @Override
    public void delete(UUID id) {
        carService.delete(id);
    }
}
