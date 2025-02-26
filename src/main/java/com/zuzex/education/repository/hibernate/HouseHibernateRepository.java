package com.zuzex.education.repository.hibernate;

import com.zuzex.education.model.db.House;
import com.zuzex.education.model.db.Person;
import com.zuzex.education.repository.HouseRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Profile("hibernate")
public interface HouseHibernateRepository extends JpaRepository<House, UUID>, HouseRepository {
    @Query(value = """
                SELECT DISTINCT owners
                FROM House house
                JOIN house.owners owners
                JOIN house.address address
                WHERE address.street = :street
            """)
    List<Person> findOwnersByHouseStreet(String street);

    @Modifying
    @Query(value = "INSERT INTO people_houses (house_id, owner_id) VALUES (:houseId, :ownerId)", nativeQuery = true)
    void saveOwners(UUID houseId, UUID ownerId);

    @Query(value = "SELECT owner_id FROM people_houses WHERE house_id = :houseId", nativeQuery = true)
    Set<UUID> findHouseOwners(UUID houseId);

    @Modifying
    @Query(value = "DELETE FROM people_houses WHERE house_id = :houseId", nativeQuery = true)
    void deleteFromPeopleHouses(UUID houseId);
}
