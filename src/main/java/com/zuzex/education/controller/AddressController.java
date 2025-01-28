package com.zuzex.education.controller;

import com.zuzex.education.dto.AddressDTO;
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

import static com.zuzex.education.constants.ResourceConstants.ADDRESSES_RESOURCE;
import static com.zuzex.education.constants.ResourceConstants.RESOURCE_VERSION_V1;

public interface AddressController {
    @GetMapping(RESOURCE_VERSION_V1 + ADDRESSES_RESOURCE + "/all")
    List<AddressDTO> getAll();

    @GetMapping(RESOURCE_VERSION_V1 + ADDRESSES_RESOURCE + "/{id}")
    AddressDTO get(@PathVariable UUID id);

    @PostMapping(RESOURCE_VERSION_V1 + ADDRESSES_RESOURCE)
    @ResponseStatus(HttpStatus.CREATED)
    AddressDTO create(@Valid @RequestBody AddressDTO addressDTO);

    @PutMapping(RESOURCE_VERSION_V1 + ADDRESSES_RESOURCE)
    AddressDTO update(@Valid @RequestBody AddressDTO addressDTO);

    @DeleteMapping(RESOURCE_VERSION_V1 + ADDRESSES_RESOURCE + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id);
}
