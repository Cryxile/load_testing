package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.house.CreateHouseRq;
import com.zuzex.education.dto.house.CreateHouseRs;
import com.zuzex.education.model.DetailedHouse;
import com.zuzex.education.model.db.Address;
import com.zuzex.education.model.db.House;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface DetailedHouseMapper {
    @Mapping(target = "id", source = "houseSource.id")
    @Mapping(target = "addressId", source = "addressSource.id")
    DetailedHouse map(House houseSource, Address addressSource);

    DetailedHouse map(CreateHouseRq source);

    CreateHouseRs map(DetailedHouse source);
}
