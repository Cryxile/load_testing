package com.zuzex.education.controller.impl;

import com.zuzex.education.controller.PersonController;
import com.zuzex.education.dto.PersonDTO;
import com.zuzex.education.mapper.PersonMapper;
import com.zuzex.education.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PersonControllerImpl implements PersonController {
    private final PersonService personService;
    private final PersonMapper personMapper;

    @Override
    public List<PersonDTO> getAll() {
        return personMapper.mapPersonToPersonDto(personService.getAll());
    }

    @Override
    public PersonDTO get(UUID id) {
        return personMapper.mapPersonToPersonDto(personService.get(id));
    }

    @Override
    public PersonDTO create(PersonDTO personDTO) {
        return personMapper.mapPersonToPersonDto(
                personService.create(personMapper.mapPersonDtoToPerson(personDTO))
        );
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        return personMapper.mapPersonToPersonDto(
                personService.update(personMapper.mapPersonDtoToPerson(personDTO))
        );
    }

    @Override
    public void delete(UUID id) {
        personService.delete(id);
    }
}
