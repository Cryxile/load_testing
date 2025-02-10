package com.zuzex.education.controller.impl;

import com.zuzex.education.controller.AddressController;
import com.zuzex.education.dto.address.AddressDTO;
import com.zuzex.education.dto.address.GetAddressListRs;
import com.zuzex.education.mapper.AddressMapper;
import com.zuzex.education.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AddressControllerImpl implements AddressController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @Override
    public GetAddressListRs getAll() {
        return addressMapper.map(addressService.getAll());
    }

    @Override
    public AddressDTO get(UUID id) {
        return addressMapper.map(addressService.get(id));
    }

    @Override
    public void delete(UUID id) {
        addressService.delete(id);
    }
}
