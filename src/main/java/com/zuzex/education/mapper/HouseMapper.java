package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.house.AddToHouseRq;
import com.zuzex.education.dto.house.AddToHouseRs;
import com.zuzex.education.dto.house.FindHousesRs;
import com.zuzex.education.dto.house.HouseDTO;
import com.zuzex.education.dto.house.UpdateHouseRq;
import com.zuzex.education.dto.house.UpdateHouseRs;
import com.zuzex.education.model.HouseOwners;
import com.zuzex.education.model.db.House;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface HouseMapper {
    House map(HouseDTO source);

    HouseDTO map(House source);

    House map(UpdateHouseRq source);

    UpdateHouseRs mapUpRs(House source);

    HouseOwners mapSettlementRq(AddToHouseRq source);

    AddToHouseRs mapSettlementRs(HouseOwners source);

    List<HouseDTO> mapToList(Collection<House> source);

    default FindHousesRs map(Collection<House> source) {
        return new FindHousesRs(mapToList(source));
    }
}
