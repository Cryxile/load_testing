package com.zuzex.education.mapper;

import com.zuzex.education.config.MapperConfiguration;
import com.zuzex.education.dto.person.FindPeopleRs;
import com.zuzex.education.dto.person.PersonDTO;
import com.zuzex.education.model.db.Person;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;


@Mapper(config = MapperConfiguration.class)
public interface PersonMapper {
    Person map(PersonDTO source);

    PersonDTO map(Person source);

    List<PersonDTO> mapToList(Collection<Person> source);

    default FindPeopleRs map(Collection<Person> source) {
        return new FindPeopleRs(mapToList(source));
    }
}
