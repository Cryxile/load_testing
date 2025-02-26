package com.zuzex.education.repository;

import com.zuzex.education.model.db.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepository {
    List<Person> findAll();
    Optional<Person> findById(UUID id);
    Person save(Person person);
    void deleteFromPeopleHouses(UUID id);
    void deleteById(UUID id);
}
