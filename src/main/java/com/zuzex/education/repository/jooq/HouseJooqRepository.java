package com.zuzex.education.repository.jooq;

import com.zuzex.education.model.db.House;
import com.zuzex.education.model.db.Person;
import com.zuzex.education.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.generated.tables.Addresses;
import org.jooq.generated.tables.Houses;
import org.jooq.generated.tables.People;
import org.jooq.generated.tables.PeopleHouses;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Profile("jooq")
@Repository
@RequiredArgsConstructor
public class HouseJooqRepository implements HouseRepository {
    private final DSLContext dslContext;

    @Override
    public List<House> findAll() {
        return dslContext.selectFrom(Houses.HOUSES)
                .fetchInto(House.class);
    }

    @Override
    public List<Person> findOwnersByHouseStreet(String street) {
        return dslContext.selectDistinct(People.PEOPLE)
                .from(Houses.HOUSES)
                .leftJoin(Addresses.ADDRESSES).on(Houses.HOUSES.ADDRESS_ID.eq(Addresses.ADDRESSES.ID))
                .leftJoin(PeopleHouses.PEOPLE_HOUSES).on(PeopleHouses.PEOPLE_HOUSES.HOUSE_ID.eq(Houses.HOUSES.ID))
                .leftJoin(People.PEOPLE).on(PeopleHouses.PEOPLE_HOUSES.OWNER_ID.eq(People.PEOPLE.ID))
                .where(Addresses.ADDRESSES.STREET.eq(street))
                .fetchInto(Person.class);
    }

    @Override
    public Set<UUID> findHouseOwners(UUID houseId) {
        return dslContext.select(PeopleHouses.PEOPLE_HOUSES.OWNER_ID)
                .from(PeopleHouses.PEOPLE_HOUSES)
                .where(PeopleHouses.PEOPLE_HOUSES.HOUSE_ID.eq(houseId))
                .fetchSet(PeopleHouses.PEOPLE_HOUSES.OWNER_ID);
    }

    @Override
    public Optional<House> findById(UUID id) {
        return dslContext.selectFrom(Houses.HOUSES)
                .where(Houses.HOUSES.ID.eq(id))
                .fetchOptionalInto(House.class);
    }

    @Override
    public House save(House house) {
       return dslContext.insertInto(Houses.HOUSES)
                .set(dslContext.newRecord(Houses.HOUSES, house))
                .onConflict(Houses.HOUSES.ID)
                .doUpdate()
                .set(dslContext.newRecord(Houses.HOUSES, house))
                .returning()
                .fetchOneInto(House.class);
    }

    @Override
    public void saveOwners(UUID houseId, UUID ownerId) {
        dslContext.insertInto(PeopleHouses.PEOPLE_HOUSES)
                .set(PeopleHouses.PEOPLE_HOUSES.HOUSE_ID, houseId)
                .set(PeopleHouses.PEOPLE_HOUSES.OWNER_ID, ownerId)
                .onConflict(PeopleHouses.PEOPLE_HOUSES.OWNER_ID, PeopleHouses.PEOPLE_HOUSES.HOUSE_ID)
                .doNothing()
                .execute();
    }

    @Override
    public void deleteFromPeopleHouses(UUID houseId) {
        dslContext.deleteFrom(PeopleHouses.PEOPLE_HOUSES)
                .where(PeopleHouses.PEOPLE_HOUSES.HOUSE_ID.eq(houseId))
                .execute();
    }

    @Override
    public void deleteById(UUID id) {
        dslContext.deleteFrom(Houses.HOUSES)
                .where(Houses.HOUSES.ID.eq(id))
                .execute();
    }
}
