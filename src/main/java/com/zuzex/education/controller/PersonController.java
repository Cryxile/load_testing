package com.zuzex.education.controller;

import com.zuzex.education.dto.person.PersonDTO;
import com.zuzex.education.dto.person.AddToPersonRq;
import com.zuzex.education.dto.person.AddToPersonRs;
import com.zuzex.education.dto.person.CreateDetailedPersonRq;
import com.zuzex.education.dto.person.CreateDetailedPersonRs;
import com.zuzex.education.dto.person.FindPeopleRs;
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

import static com.zuzex.education.constants.ResourceConstants.PEOPLE_RESOURCE;
import static com.zuzex.education.constants.ResourceConstants.RESOURCE_VERSION_V1;

public interface PersonController {
    @GetMapping(RESOURCE_VERSION_V1 + PEOPLE_RESOURCE)
    FindPeopleRs findAll();

    @GetMapping(RESOURCE_VERSION_V1 + PEOPLE_RESOURCE + "/{id}")
    PersonDTO get(@PathVariable @NotNull UUID id);

    @PutMapping(RESOURCE_VERSION_V1 + PEOPLE_RESOURCE + "/house")
    AddToPersonRs addHouseToPerson(@Valid @RequestBody AddToPersonRq person);

    @PostMapping(RESOURCE_VERSION_V1 + PEOPLE_RESOURCE)
    @ResponseStatus(HttpStatus.CREATED)
    CreateDetailedPersonRs create(@Valid @RequestBody CreateDetailedPersonRq person);

    @PutMapping(RESOURCE_VERSION_V1 + PEOPLE_RESOURCE)
    PersonDTO update(@Valid @RequestBody PersonDTO personDTO);

    @DeleteMapping(RESOURCE_VERSION_V1 + PEOPLE_RESOURCE + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable @NotNull UUID id);
}
