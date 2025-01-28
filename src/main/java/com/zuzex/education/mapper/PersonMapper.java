package com.zuzex.education.mapper;

import com.zuzex.education.dto.PersonDTO;
import com.zuzex.education.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(source = "passportId", target = "passport.id")
    Person mapPersonDtoToPerson(PersonDTO personDTO);

    @Mapping(source = "passport.id", target = "passportId")
    PersonDTO mapPersonToPersonDto(Person person);

    @Mapping(source = "passport.id", target = "passportId")
    List<PersonDTO> mapPersonToPersonDto(List<Person> person);
}
