package com.zuzex.education.service;

import com.zuzex.education.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    List<Person> getAll();

    Person get(UUID id);

    Person create(Person person);

    Person update(Person person);

    void delete(UUID id);
}
