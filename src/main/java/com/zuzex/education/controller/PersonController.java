package com.zuzex.education.controller;

import com.zuzex.education.dto.PersonDTO;
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

import static com.zuzex.education.constants.ResourceConstants.PEOPLE_RESOURCE;
import static com.zuzex.education.constants.ResourceConstants.RESOURCE_VERSION_V1;

public interface PersonController {
    @GetMapping(RESOURCE_VERSION_V1 + PEOPLE_RESOURCE + "/all")
    public List<PersonDTO> getAll();

    @GetMapping(RESOURCE_VERSION_V1 + PEOPLE_RESOURCE + "/{id}")
    public PersonDTO get(@PathVariable UUID id);

    @PostMapping(RESOURCE_VERSION_V1 + PEOPLE_RESOURCE)
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO create(@Valid @RequestBody PersonDTO personDTO);

    @PutMapping(RESOURCE_VERSION_V1 + PEOPLE_RESOURCE)
    public PersonDTO update(@Valid @RequestBody PersonDTO personDTO);

    @DeleteMapping(RESOURCE_VERSION_V1 + PEOPLE_RESOURCE + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id);
}
