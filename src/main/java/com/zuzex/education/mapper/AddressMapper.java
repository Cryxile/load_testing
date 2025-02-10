package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.address.AddressDTO;
import com.zuzex.education.dto.address.GetAddressListRs;
import com.zuzex.education.model.db.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface AddressMapper {
    Address map(AddressDTO source);

    AddressDTO map(Address source);

    default GetAddressListRs map(List<Address> source) {
        return GetAddressListRs.builder().list(source.stream().map(this::map).toList()).build();
    }
}
