package com.zuzex.education.controller.impl;

import com.zuzex.education.controller.HouseController;
import com.zuzex.education.dto.HouseDTO;
import com.zuzex.education.mapper.HouseMapper;
import com.zuzex.education.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class HouseControllerImpl implements HouseController {

    private final HouseService houseService;
    private final HouseMapper houseMapper;

    @Override
    public List<HouseDTO> getAll() {
        return houseMapper.mapHouseToHouseDto(houseService.getAll());
    }

    @Override
    public HouseDTO get(UUID id) {
        return houseMapper.mapHouseToHouseDto(houseService.get(id));
    }

    @Override
    public HouseDTO create(HouseDTO houseDTO) {
        return houseMapper.mapHouseToHouseDto(
                houseService.create(houseMapper.mapHouseDtoToHouse(houseDTO))
        );
    }

    @Override
    public HouseDTO update(HouseDTO houseDTO) {
        return houseMapper.mapHouseToHouseDto(
                houseService.update(houseMapper.mapHouseDtoToHouse(houseDTO))
        );
    }

    @Override
    public void delete(UUID id) {
        houseService.delete(id);
    }
}
