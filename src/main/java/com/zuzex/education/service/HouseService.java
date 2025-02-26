package com.zuzex.education.service;

import com.zuzex.education.model.HouseOwners;
import com.zuzex.education.model.db.House;
import com.zuzex.education.model.db.Person;

import java.util.List;
import java.util.UUID;

public interface HouseService {
    List<House> findAll();

    List<Person> findOwnersByHouseStreet(String street);

    HouseOwners addOwnersToHouse(HouseOwners owners);

    House get(UUID id);

    House create(House house);

    House update(House house);

    void delete(UUID id);
}
