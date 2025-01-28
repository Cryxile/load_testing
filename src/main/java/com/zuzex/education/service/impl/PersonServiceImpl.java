package com.zuzex.education.service.impl;

import com.zuzex.education.exception.PersonNotFoundException;
import com.zuzex.education.model.Person;
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
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person get(UUID id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(
                person.toBuilder()
                        .id(UUID.randomUUID())
                        .build()
        );
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(UUID id) {
        personRepository.deleteById(id);
    }
}
