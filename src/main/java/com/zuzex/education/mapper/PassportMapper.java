package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.passport.FindPassportsRs;
import com.zuzex.education.dto.passport.PassportDTO;
import com.zuzex.education.dto.passport.UpdatePassportRq;
import com.zuzex.education.dto.passport.UpdatePassportRs;
import com.zuzex.education.model.db.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface PassportMapper {
    @Mapping(target = "addressId", source = "residentAddressId")
    PassportDTO map(Passport source);

    @Mapping(target = "residentAddressId", source = "addressId")
    Passport map(UpdatePassportRq source);

    @Mapping(target = "addressId", source = "residentAddressId")
    UpdatePassportRs mapRs(Passport source);

    List<PassportDTO> mapToList(Collection<Passport> source);

    default FindPassportsRs map(Collection<Passport> source) {
        return new FindPassportsRs(mapToList(source));
    }
}
