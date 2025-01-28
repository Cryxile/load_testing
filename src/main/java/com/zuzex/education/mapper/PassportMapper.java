package com.zuzex.education.mapper;

import com.zuzex.education.dto.PassportDTO;
import com.zuzex.education.model.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassportMapper {
    @Mapping(source = "addressId", target = "residentAddress.id")
    Passport mapPassportDtoToPassport(PassportDTO passportDTO);

    @Mapping(source = "residentAddress.id", target = "addressId")
    PassportDTO mapPassportToPassportDTO(Passport passport);

    @Mapping(source = "residentAddress.id", target = "addressId")
    List<PassportDTO> mapPassportToPassportDTO(List<Passport> passports);
}
