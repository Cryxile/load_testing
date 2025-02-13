package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.house.AddToHouseRq;
import com.zuzex.education.dto.house.AddToHouseRs;
import com.zuzex.education.dto.house.CreateHouseRq;
import com.zuzex.education.dto.house.CreateHouseRs;
import com.zuzex.education.dto.house.FindHousesRs;
import com.zuzex.education.dto.house.HouseDTO;
import com.zuzex.education.dto.house.UpdateHouseRq;
import com.zuzex.education.dto.house.UpdateHouseRs;
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
public interface HouseMapper {
    @Mapping(target = "address.id", source = "addressId")
    House map(HouseDTO source);

    @Mapping(target = "addressId", source = "address.id")
    HouseDTO map(House source);

    @Mapping(target = "address.city", source = "city")
    @Mapping(target = "address.street", source = "street")
    @Mapping(target = "address.houseNumber", source = "houseNumber")
    House map(CreateHouseRq source);

    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "houseNumber", source = "address.houseNumber")
    @Mapping(target = "addressId", source = "address.id")
    CreateHouseRs mapCrRs(House source);

    House map(UpdateHouseRq source);

    UpdateHouseRs mapUpRs(House source);

    @Mapping(target = "id", source = "houseId")
    House mapSettlementRq(AddToHouseRq source);

    AddToHouseRs mapSettlementRs(House source);

    default FindHousesRs map(Collection<House> source) {
        return FindHousesRs.builder().houses(source.stream().map(this::map).toList()).build();
    }

    @AfterMapping
    default AddToHouseRs convertIntoId(House source, @MappingTarget AddToHouseRs target) {
        return target.toBuilder()
                .houseOwners(source.getOwners().stream().map(Person::getId).collect(Collectors.toSet()))
                .build();
    }

    @AfterMapping
    default House convertIntoPerson(AddToHouseRq source, @MappingTarget House target) {
        Set<Person> people = source.getHouseOwners().stream()
                .map(id -> Person.builder().id(id).build())
                .collect(Collectors.toSet());
        return target.toBuilder().owners(people).build();
    }
}
