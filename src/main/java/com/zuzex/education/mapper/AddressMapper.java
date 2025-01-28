package com.zuzex.education.mapper;

import com.zuzex.education.dto.AddressDTO;
import com.zuzex.education.model.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address mapAddressDtoToAddress(AddressDTO addressDto);

    AddressDTO mapAddressToAddressDto(Address address);

    List<AddressDTO> mapAddressToAddressDto(List<Address> addresses);
}
