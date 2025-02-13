package com.zuzex.education.controller.impl;

import com.zuzex.education.controller.PersonController;
import com.zuzex.education.dto.person.PersonDTO;
import com.zuzex.education.dto.person.AddToPersonRq;
import com.zuzex.education.dto.person.AddToPersonRs;
import com.zuzex.education.dto.person.CreateDetailedPersonRq;
import com.zuzex.education.dto.person.CreateDetailedPersonRs;
import com.zuzex.education.dto.person.FindPeopleRs;
import com.zuzex.education.interactor.DetailedPersonInteractor;
import com.zuzex.education.mapper.DetailedPersonMapper;
import com.zuzex.education.mapper.PersonMapper;
import com.zuzex.education.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PersonControllerImpl implements PersonController {
    private final PersonService personService;
    private final DetailedPersonInteractor detailedPersonInteractor;
    private final PersonMapper personMapper;
    private final DetailedPersonMapper detailedPersonMapper;

    @Override
    public FindPeopleRs findAll() {
        return personMapper.map(personService.findAll());
    }

    @Override
    public PersonDTO get(UUID id) {
        return personMapper.map(personService.get(id));
    }

    @Override
    public AddToPersonRs addHouseToPerson(AddToPersonRq person) {
        return personMapper.mapRs(personService.addHouseToPerson(personMapper.map(person)));
    }

    @Override
    public CreateDetailedPersonRs create(CreateDetailedPersonRq person) {
        return detailedPersonMapper.map(
                detailedPersonInteractor.createPerson(
                        detailedPersonMapper.map(person)
                )
        );
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        return personMapper.map(
                personService.update(
                        personMapper.map(personDTO)
                )
        );
    }

    @Override
    public void delete(UUID id) {
        detailedPersonInteractor.deletePerson(id);
    }
}
