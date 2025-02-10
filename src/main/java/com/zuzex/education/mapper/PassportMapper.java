package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.passport.PassportDTO;
import com.zuzex.education.dto.passport.GetPassportListRs;
import com.zuzex.education.dto.passport.UpdatePassportRq;
import com.zuzex.education.dto.passport.UpdatePassportRs;
import com.zuzex.education.model.db.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface PassportMapper {
    @Mapping(target = "addressId", source = "residentAddress.id")
    @Mapping(target = "ownerId", source = "owner.id")
    PassportDTO map(Passport source);

    @Mapping(target = "residentAddress.id", source = "addressId")
    Passport map(UpdatePassportRq source);

    @Mapping(target = "addressId", source = "residentAddress.id")
    UpdatePassportRs mapRs(Passport source);

    default GetPassportListRs map(List<Passport> source) {
        return GetPassportListRs.builder().list(source.stream().map(this::map).toList()).build();
    }
}
