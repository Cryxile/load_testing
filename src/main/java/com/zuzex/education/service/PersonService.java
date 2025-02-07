package com.zuzex.education.service;

import com.zuzex.education.model.db.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    List<Person> getAll();

    Person get(UUID id);

    Person addHouseToPerson(Person person);

    Person create(Person person);

    Person update(Person person);

    void deleteFromPeopleHouses(UUID id);

    void deleteFromPeople(UUID id);
}
