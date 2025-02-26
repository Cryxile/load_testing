package com.zuzex.education.repository.jooq;

import com.zuzex.education.model.db.Person;
import com.zuzex.education.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.generated.tables.People;
import org.jooq.generated.tables.PeopleHouses;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Profile("jooq")
@Repository
@RequiredArgsConstructor
public class PersonJooqRepository implements PersonRepository {
    private final DSLContext dslContext;

    @Override
    public List<Person> findAll() {
        return dslContext.selectFrom(People.PEOPLE)
                .fetchInto(Person.class);
    }

    @Override
    public Optional<Person> findById(UUID id) {
        return dslContext.selectFrom(People.PEOPLE)
                .where(People.PEOPLE.ID.eq(id))
                .fetchOptionalInto(Person.class);
    }

    @Override
    public Person save(Person person) {
        return dslContext.insertInto(People.PEOPLE)
                .set(dslContext.newRecord(People.PEOPLE, person))
                .onConflict(People.PEOPLE.ID)
                .doUpdate()
                .set(dslContext.newRecord(People.PEOPLE, person))
                .returning()
                .fetchOneInto(Person.class);
    }

    @Override
    public void deleteFromPeopleHouses(UUID id) {
        dslContext.deleteFrom(PeopleHouses.PEOPLE_HOUSES)
                .where(PeopleHouses.PEOPLE_HOUSES.OWNER_ID.eq(id))
                .execute();
    }

    @Override
    public void deleteById(UUID id) {
        dslContext.deleteFrom(People.PEOPLE)
                .where(People.PEOPLE.ID.eq(id))
                .execute();
    }
}
