package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.car.CarDTO;
import com.zuzex.education.dto.car.CreateCarRq;
import com.zuzex.education.dto.car.CreateCarRs;
import com.zuzex.education.dto.car.GetCarListRs;
import com.zuzex.education.model.db.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface CarMapper {
    @Mapping(target = "ownerId", source = "owner.id")
    CarDTO map(Car source);

    @Mapping(target = "owner.id", source = "ownerId")
    Car map(CarDTO source);

    @Mapping(target = "owner.id", source = "ownerId")
    Car map(CreateCarRq source);

    @Mapping(target = "ownerId", source = "owner.id")
    CreateCarRs mapRs(Car source);

    default GetCarListRs map(List<Car> source) {
        return GetCarListRs.builder().list(source.stream().map(this::map).toList()).build();
    }
}
