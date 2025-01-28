package com.zuzex.education.controller;

import com.zuzex.education.dto.PassportDTO;
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

import static com.zuzex.education.constants.ResourceConstants.PASSPORTS_RESOURCE;
import static com.zuzex.education.constants.ResourceConstants.RESOURCE_VERSION_V1;

public interface PassportController {
    @GetMapping(RESOURCE_VERSION_V1 + PASSPORTS_RESOURCE + "/all")
    List<PassportDTO> getAll();

    @GetMapping(RESOURCE_VERSION_V1 + PASSPORTS_RESOURCE + "/{id}")
    PassportDTO get(@PathVariable UUID id);

    @PostMapping(RESOURCE_VERSION_V1 + PASSPORTS_RESOURCE)
    @ResponseStatus(HttpStatus.CREATED)
    PassportDTO create(@Valid @RequestBody PassportDTO passportDTO);

    @PutMapping(RESOURCE_VERSION_V1 + PASSPORTS_RESOURCE)
    PassportDTO update(@Valid @RequestBody PassportDTO passportDTO);

    @DeleteMapping(RESOURCE_VERSION_V1 + PASSPORTS_RESOURCE + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id);
}
