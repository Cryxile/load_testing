package com.zuzex.education.mapper;

import com.zuzex.education.dto.CarDTO;
import com.zuzex.education.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(source = "owner.id", target = "personId")
    CarDTO mapCarToCarDto(Car car);

    @Mapping(source = "owner.id", target = "personId")
    List<CarDTO> mapCarToCarDto(List<Car> cars);

    @Mapping(source = "personId", target = "owner.id")
    Car mapCarDtoToCar(CarDTO carDTO);
}
