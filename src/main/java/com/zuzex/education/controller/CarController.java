package com.zuzex.education.controller;

import com.zuzex.education.dto.car.CarDTO;
import com.zuzex.education.dto.car.CreateCarRq;
import com.zuzex.education.dto.car.CreateCarRs;
import com.zuzex.education.dto.car.GetCarListRs;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import static com.zuzex.education.constants.ResourceConstants.CARS_RESOURCE;
import static com.zuzex.education.constants.ResourceConstants.RESOURCE_VERSION_V1;

public interface CarController {
    @GetMapping(RESOURCE_VERSION_V1 + CARS_RESOURCE)
    GetCarListRs getAll();

    @GetMapping(RESOURCE_VERSION_V1 + CARS_RESOURCE + "/owner/{id}")
    GetCarListRs getAllByOwner(@PathVariable @NotNull UUID id);

    @GetMapping(RESOURCE_VERSION_V1 + CARS_RESOURCE + "/{id}")
    CarDTO get(@PathVariable UUID id);

    @PostMapping(RESOURCE_VERSION_V1 + CARS_RESOURCE)
    @ResponseStatus(HttpStatus.CREATED)
    CreateCarRs create(@Valid @RequestBody CreateCarRq car);

    @PutMapping(RESOURCE_VERSION_V1 + CARS_RESOURCE)
    CarDTO update(@Valid @RequestBody CarDTO carDTO);

    @DeleteMapping(RESOURCE_VERSION_V1 + CARS_RESOURCE + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable @NotNull UUID id);
}
