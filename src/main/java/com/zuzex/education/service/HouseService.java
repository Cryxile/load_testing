package com.zuzex.education.service;

import com.zuzex.education.model.db.House;
import com.zuzex.education.model.db.Person;

import java.util.List;
import java.util.UUID;

public interface HouseService {
    List<House> findAll();

    List<Person> findOwnersByHouseStreet(String street);

    House addOwnersToHouse(House house);

    House get(UUID id);

    House create(House house);

    House update(House house);

    void delete(UUID id);
}
