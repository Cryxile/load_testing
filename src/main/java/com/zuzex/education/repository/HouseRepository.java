package com.zuzex.education.repository;

import com.zuzex.education.model.db.House;
import com.zuzex.education.model.db.Person;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface HouseRepository {
    List<House> findAll();
    List<Person> findOwnersByHouseStreet(String street);
    Set<UUID> findHouseOwners(UUID houseId);
    Optional<House> findById(UUID id);
    House save(House house);
    void saveOwners(UUID houseId, UUID ownerId);
    void deleteFromPeopleHouses(UUID id);
    void deleteById(UUID id);
}
