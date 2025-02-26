package com.zuzex.education.interactor.impl;

import com.zuzex.education.mapper.DetailedHouseMapper;
import com.zuzex.education.model.DetailedHouse;
import com.zuzex.education.model.db.Address;
import com.zuzex.education.model.db.House;
import com.zuzex.education.service.AddressService;
import com.zuzex.education.interactor.DetailedHouseInteractor;
import com.zuzex.education.service.HouseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DetailedHouseInteractorImpl implements DetailedHouseInteractor {
    private final HouseService houseService;
    private final AddressService addressService;
    private final DetailedHouseMapper detailedHouseMapper;

    @Override
    @Transactional
    public DetailedHouse createHouse(DetailedHouse house) {
        Address newAddress = addressService.create(
                Address.builder()
                        .id(UUID.randomUUID())
                        .city(house.getCity())
                        .street(house.getStreet())
                        .houseNumber(house.getHouseNumber())
                        .build()
        );
        House newHouse = houseService.create(
                House.builder()
                        .id(UUID.randomUUID())
                        .wallMaterial(house.getWallMaterial())
                        .buildDate(house.getBuildDate())
                        .hasGasSupply(house.getHasGasSupply())
                        .addressId(newAddress.getId())
                        .build()
        );
        return detailedHouseMapper.map(newHouse, newAddress);
    }
}
