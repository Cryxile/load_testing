package com.zuzex.education.interactor.impl;

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

    @Override
    @Transactional
    public House createHouse(House house) {
        Address newAddress = addressService.create(
                Address.builder()
                        .id(UUID.randomUUID())
                        .city(house.getAddress().getCity())
                        .street(house.getAddress().getStreet())
                        .houseNumber(house.getAddress().getHouseNumber())
                        .build()
        );
        return houseService.create(
                House.builder()
                        .id(UUID.randomUUID())
                        .wallMaterial(house.getWallMaterial())
                        .buildDate(house.getBuildDate())
                        .hasGasSupply(house.getHasGasSupply())
                        .address(newAddress)
                        .build()
        );
    }
}
