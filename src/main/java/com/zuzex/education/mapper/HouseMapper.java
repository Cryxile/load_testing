package com.zuzex.education.mapper;

import com.zuzex.education.dto.HouseDTO;
import com.zuzex.education.model.House;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {
    @Mapping(source = "addressId", target = "address.id")
    House mapHouseDtoToHouse(HouseDTO houseDTO);

    @Mapping(source = "address.id", target = "addressId")
    HouseDTO mapHouseToHouseDto(House house);

    @Mapping(source = "address.id", target = "addressId")
    List<HouseDTO> mapHouseToHouseDto(List<House> house);
}
