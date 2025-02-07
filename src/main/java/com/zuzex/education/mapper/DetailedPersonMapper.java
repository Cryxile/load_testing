package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.person.CreateDetailedPersonRq;
import com.zuzex.education.dto.person.CreateDetailedPersonRs;
import com.zuzex.education.model.DetailedPerson;
import com.zuzex.education.model.db.Passport;
import com.zuzex.education.model.db.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface DetailedPersonMapper {
    @Mapping(target = "passportId", source = "passportSource.id")
    @Mapping(target = "id", source = "personSource.id")
    @Mapping(target = "addressId", source = "passportSource.residentAddress.id")
    DetailedPerson map(Person personSource, Passport passportSource);

    DetailedPerson map(CreateDetailedPersonRq source);

    CreateDetailedPersonRs map(DetailedPerson source);
}
