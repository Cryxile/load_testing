package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.address.AddressDTO;
import com.zuzex.education.dto.address.FindAddressesRs;
import com.zuzex.education.model.db.Address;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface AddressMapper {
    Address map(AddressDTO source);

    AddressDTO map(Address source);
    List<AddressDTO> mapToList(Collection<Address> source);

    default FindAddressesRs map(Collection<Address> source) {
        return new FindAddressesRs(mapToList(source));
    }
}
