package com.zuzex.education.service.impl;

import com.zuzex.education.exception.HouseNotFoundException;
import com.zuzex.education.model.HouseOwners;
import com.zuzex.education.model.db.House;
import com.zuzex.education.model.db.Person;
import com.zuzex.education.repository.HouseRepository;
import com.zuzex.education.service.HouseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public List<Person> findOwnersByHouseStreet(String street) {
        return houseRepository.findOwnersByHouseStreet(street);
    }

    @Override
    public House get(UUID id) {
        return houseRepository.findById(id).orElseThrow(() -> new HouseNotFoundException(id));
    }

    @Override
    public HouseOwners addOwnersToHouse(HouseOwners owners) {
        UUID houseId = owners.getHouseId();
        owners.getHouseOwners().forEach(owner -> houseRepository.saveOwners(houseId, owner));
        return HouseOwners.builder().houseId(houseId).houseOwners(houseRepository.findHouseOwners(houseId)).build();
    }

    @Override
    public House create(House house) {
        return houseRepository.save(house);
    }

    @Override
    public House update(House house) {
        return houseRepository.save(house);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        houseRepository.deleteFromPeopleHouses(id);
        houseRepository.deleteById(id);
    }
}
