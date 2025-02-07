package com.zuzex.education.controller.impl;

import com.zuzex.education.controller.HouseController;
import com.zuzex.education.dto.house.HouseDTO;
import com.zuzex.education.dto.house.AddToHouseRq;
import com.zuzex.education.dto.house.AddToHouseRs;
import com.zuzex.education.dto.house.CreateHouseRq;
import com.zuzex.education.dto.house.CreateHouseRs;
import com.zuzex.education.dto.house.GetHouseListRs;
import com.zuzex.education.dto.person.GetPersonListRs;
import com.zuzex.education.dto.house.UpdateHouseRq;
import com.zuzex.education.dto.house.UpdateHouseRs;
import com.zuzex.education.interactor.DetailedHouseInteractor;
import com.zuzex.education.mapper.HouseMapper;
import com.zuzex.education.mapper.PersonMapper;
import com.zuzex.education.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class HouseControllerImpl implements HouseController {
    private final HouseService houseService;
    private final DetailedHouseInteractor detailedHouseInteractor;
    private final HouseMapper houseMapper;
    private final PersonMapper personMapper;

    @Override
    public GetHouseListRs getAll() {
        return houseMapper.map(houseService.getAll());
    }

    @Override
    public GetPersonListRs getAllByHouseStreet(String street) {
        return personMapper.map(
                houseService.getAllByHouseStreet(street)
        );
    }

    @Override
    public HouseDTO get(UUID id) {
        return houseMapper.map(
                houseService.get(id)
        );
    }

    @Override
    public AddToHouseRs addToHouse(AddToHouseRq house) {
        return houseMapper.mapSettlementRs(
                houseService.addOwnersToHouse(
                        houseMapper.mapSettlementRq(house)
                )
        );
    }

    @Override
    public CreateHouseRs create(CreateHouseRq house) {
        return houseMapper.mapCrRs(
                detailedHouseInteractor.createHouse(
                        houseMapper.map(house)
                )
        );
    }

    @Override
    public UpdateHouseRs update(UpdateHouseRq house) {
        return houseMapper.mapUpRs(
                houseService.update(
                        houseMapper.map(house)
                )
        );
    }

    @Override
    public void delete(UUID id) {
        houseService.delete(id);
    }
}
