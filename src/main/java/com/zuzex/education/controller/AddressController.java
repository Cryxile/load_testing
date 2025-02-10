package com.zuzex.education.controller;

import com.zuzex.education.dto.address.AddressDTO;
import com.zuzex.education.dto.address.GetAddressListRs;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import static com.zuzex.education.constants.ResourceConstants.ADDRESSES_RESOURCE;
import static com.zuzex.education.constants.ResourceConstants.RESOURCE_VERSION_V1;

public interface AddressController {
    @GetMapping(RESOURCE_VERSION_V1 + ADDRESSES_RESOURCE)
    GetAddressListRs getAll();

    @GetMapping(RESOURCE_VERSION_V1 + ADDRESSES_RESOURCE + "/{id}")
    AddressDTO get(@PathVariable @NotNull UUID id);

    @DeleteMapping(RESOURCE_VERSION_V1 + ADDRESSES_RESOURCE + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable @NotNull UUID id);
}
