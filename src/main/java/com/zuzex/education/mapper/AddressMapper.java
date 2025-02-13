package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.address.AddressDTO;
import com.zuzex.education.dto.address.FindAddressesRs;
import com.zuzex.education.model.db.Address;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(config = MapperConfiguration.class)
public interface AddressMapper {
    Address map(AddressDTO source);

    AddressDTO map(Address source);

    default FindAddressesRs map(Collection<Address> source) {
        return FindAddressesRs.builder().addresses(source.stream().map(this::map).toList()).build();
    }
}
