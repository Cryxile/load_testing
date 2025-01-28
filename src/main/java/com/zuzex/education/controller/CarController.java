package com.zuzex.education.controller;

import com.zuzex.education.dto.CarDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;

import static com.zuzex.education.constants.ResourceConstants.CARS_RESOURCE;
import static com.zuzex.education.constants.ResourceConstants.RESOURCE_VERSION_V1;

public interface CarController {
    @GetMapping(RESOURCE_VERSION_V1 + CARS_RESOURCE + "/all")
    List<CarDTO> getAll();

    @GetMapping(RESOURCE_VERSION_V1 + CARS_RESOURCE + "/{id}")
    CarDTO get(@PathVariable UUID id);

    @PostMapping(RESOURCE_VERSION_V1 + CARS_RESOURCE)
    @ResponseStatus(HttpStatus.CREATED)
    CarDTO create(@Valid @RequestBody CarDTO carDTO);

    @PutMapping(RESOURCE_VERSION_V1 + CARS_RESOURCE)
    CarDTO update(@Valid @RequestBody CarDTO carDTO);

    @DeleteMapping(RESOURCE_VERSION_V1 + CARS_RESOURCE + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id);
}
