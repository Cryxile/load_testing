package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.car.CarDTO;
import com.zuzex.education.dto.car.CreateCarRq;
import com.zuzex.education.dto.car.CreateCarRs;
import com.zuzex.education.dto.car.FindCarsRs;
import com.zuzex.education.model.db.Car;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface CarMapper {
    CarDTO map(Car source);

    Car map(CarDTO source);

    Car map(CreateCarRq source);

    CreateCarRs mapRs(Car source);

    List<CarDTO> mapToList(Collection<Car> source);

    default FindCarsRs map(Collection<Car> source) {
        return new FindCarsRs(mapToList(source));
    }
}
