package com.zuzex.education.interactor.impl;

import com.zuzex.education.mapper.DetailedPersonMapper;
import com.zuzex.education.model.DetailedPerson;
import com.zuzex.education.model.db.Address;
import com.zuzex.education.model.db.Passport;
import com.zuzex.education.model.db.Person;
import com.zuzex.education.service.CarService;
import com.zuzex.education.interactor.DetailedPersonInteractor;
import com.zuzex.education.service.PassportService;
import com.zuzex.education.service.PersonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DetailedPersonInteractorImpl implements DetailedPersonInteractor {
    private final PersonService personService;
    private final PassportService passportService;
    private final CarService carService;
    private final DetailedPersonMapper detailedPersonMapper;

    @Override
    @Transactional
    public DetailedPerson createPerson(DetailedPerson detailedPerson) {
        Person newPerson = personService.create(
                Person.builder()
                        .height(detailedPerson.getHeight())
                        .weight(detailedPerson.getWeight())
                        .hairColor(detailedPerson.getHairColor())
                        .build()
        );
        Passport newPassport = passportService.create(
                Passport.builder()
                        .firstName(detailedPerson.getFirstName())
                        .lastName(detailedPerson.getLastName())
                        .birthDate(detailedPerson.getBirthDate())
                        .gender(detailedPerson.getGender())
                        .owner(newPerson)
                        .residentAddress(Address.builder().id(detailedPerson.getAddressId()).build())
                        .build()
        );
        return detailedPersonMapper.map(newPerson, newPassport);
    }

    @Override
    @Transactional
    public void deletePerson(UUID id) {
        personService.deleteFromPeopleHouses(id);
        passportService.deleteByOwner(id);
        carService.deleteByOwner(id);
        personService.deleteFromPeople(id);
    }
}
