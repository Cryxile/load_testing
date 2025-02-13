package com.zuzex.education.service.impl;

import com.zuzex.education.exception.PersonNotFoundException;
import com.zuzex.education.model.db.Person;
import com.zuzex.education.repository.PersonRepository;
import com.zuzex.education.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person get(UUID id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    public Person addHouseToPerson(Person person) {
        UUID personId = person.getId();
        return personRepository.save(
                personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException(personId))
                        .toBuilder()
                        .houses(person.getHouses())
                        .build()
        );
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(
                Person.builder()
                        .id(UUID.randomUUID())
                        .height(person.getHeight())
                        .weight(person.getWeight())
                        .hairColor(person.getHairColor())
                        .build()
        );
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deleteFromPeopleHouses(UUID id) {
        personRepository.deleteFromPeopleHouses(id);
    }

    @Override
    public void deleteFromPeople(UUID id) {
        personRepository.deleteById(id);
    }
}
