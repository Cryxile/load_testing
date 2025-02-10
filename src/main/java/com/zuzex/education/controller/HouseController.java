package com.zuzex.education.controller;

import com.zuzex.education.dto.house.HouseDTO;
import com.zuzex.education.dto.house.AddToHouseRq;
import com.zuzex.education.dto.house.AddToHouseRs;
import com.zuzex.education.dto.house.CreateHouseRq;
import com.zuzex.education.dto.house.CreateHouseRs;
import com.zuzex.education.dto.house.GetHouseListRs;
import com.zuzex.education.dto.person.GetPersonListRs;
import com.zuzex.education.dto.house.UpdateHouseRq;
import com.zuzex.education.dto.house.UpdateHouseRs;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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

import static com.zuzex.education.constants.ResourceConstants.HOUSES_RESOURCE;
import static com.zuzex.education.constants.ResourceConstants.RESOURCE_VERSION_V1;

public interface HouseController {
    @GetMapping(RESOURCE_VERSION_V1 + HOUSES_RESOURCE)
    GetHouseListRs getAll();

    @GetMapping(RESOURCE_VERSION_V1 + HOUSES_RESOURCE + "/owners/{street}")
    GetPersonListRs getAllByHouseStreet(@PathVariable @NotBlank String street);

    @GetMapping(RESOURCE_VERSION_V1 + HOUSES_RESOURCE + "/{id}")
    HouseDTO get(@PathVariable @NotNull UUID id);

    @PutMapping(RESOURCE_VERSION_V1 + HOUSES_RESOURCE + "/owner")
    AddToHouseRs addToHouse(@Valid @RequestBody AddToHouseRq house);

    @PostMapping(RESOURCE_VERSION_V1 + HOUSES_RESOURCE)
    @ResponseStatus(HttpStatus.CREATED)
    CreateHouseRs create(@Valid @RequestBody CreateHouseRq house);

    @PutMapping(RESOURCE_VERSION_V1 + HOUSES_RESOURCE)
    UpdateHouseRs update(@Valid @RequestBody UpdateHouseRq house);

    @DeleteMapping(RESOURCE_VERSION_V1 + HOUSES_RESOURCE + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable @NotNull UUID id);
}
