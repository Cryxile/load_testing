package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.person.AddToPersonRq;
import com.zuzex.education.dto.person.AddToPersonRs;
import com.zuzex.education.dto.person.FindPeopleRs;
import com.zuzex.education.dto.person.PersonDTO;
import com.zuzex.education.model.db.House;
import com.zuzex.education.model.db.Person;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Mapper(config = MapperConfiguration.class)
public interface PersonMapper {
    Person map(PersonDTO source);

    PersonDTO map(Person source);

    @Mapping(target = "id", source = "personId")
    Person map(AddToPersonRq source);

    AddToPersonRs mapRs(Person source);

    default FindPeopleRs map(Collection<Person> source) {
        return FindPeopleRs.builder().people(source.stream().map(this::map).toList()).build();
    }

    @AfterMapping
    default AddToPersonRs convertIntoId(Person source, @MappingTarget AddToPersonRs target) {
        return target.toBuilder()
                .ownedHouses(source.getHouses().stream().map(House::getId).collect(Collectors.toSet()))
                .build();
    }

    @AfterMapping
    default Person convertIntoHouse(AddToPersonRq source, @MappingTarget Person target) {
        Set<House> houses = source.getOwnedHouses().stream()
                .map(id -> House.builder().id(id).build())
                .collect(Collectors.toSet());
        return target.toBuilder().houses(houses).build();
    }
}
