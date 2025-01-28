package com.zuzex.education.controller;

import com.zuzex.education.dto.HouseDTO;
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

import static com.zuzex.education.constants.ResourceConstants.HOUSES_RESOURCE;
import static com.zuzex.education.constants.ResourceConstants.RESOURCE_VERSION_V1;

public interface HouseController {
    @GetMapping(RESOURCE_VERSION_V1 + HOUSES_RESOURCE + "/all")
    List<HouseDTO> getAll();

    @GetMapping(RESOURCE_VERSION_V1 + HOUSES_RESOURCE + "/{id}")
    HouseDTO get(@PathVariable UUID id);

    @PostMapping(RESOURCE_VERSION_V1 + HOUSES_RESOURCE)
    @ResponseStatus(HttpStatus.CREATED)
    HouseDTO create(@Valid @RequestBody HouseDTO houseDTO);

    @PutMapping(RESOURCE_VERSION_V1 + HOUSES_RESOURCE)
    HouseDTO update(@Valid @RequestBody HouseDTO houseDTO);

    @DeleteMapping(RESOURCE_VERSION_V1 + HOUSES_RESOURCE + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id);
}
