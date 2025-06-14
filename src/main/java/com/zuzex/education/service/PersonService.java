package com.zuzex.education.service;

import com.zuzex.education.model.db.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    List<Person> findAll();

    Person get(UUID id);

    Person create(Person person);

    Person update(Person person);

    void deleteFromPeopleHouses(UUID id);

    void deleteFromPeople(UUID id);
}
