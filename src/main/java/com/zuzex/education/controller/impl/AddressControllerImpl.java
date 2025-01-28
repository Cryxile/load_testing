package com.zuzex.education.controller.impl;

import com.zuzex.education.controller.AddressController;
import com.zuzex.education.dto.AddressDTO;
import com.zuzex.education.mapper.AddressMapper;
import com.zuzex.education.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AddressControllerImpl implements AddressController {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @Override
    public List<AddressDTO> getAll() {
        return addressMapper.mapAddressToAddressDto(addressService.getAll());
    }

    @Override
    public AddressDTO get(UUID id) {
        return addressMapper.mapAddressToAddressDto(addressService.get(id));
    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) {
        return addressMapper.mapAddressToAddressDto(
                addressService.create(addressMapper.mapAddressDtoToAddress(addressDTO))
        );
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        return addressMapper.mapAddressToAddressDto(
                addressService.update(addressMapper.mapAddressDtoToAddress(addressDTO))
        );
    }

    @Override
    public void delete(UUID id) {
        addressService.delete(id);
    }
}
