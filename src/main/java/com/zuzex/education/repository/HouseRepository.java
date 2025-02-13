package com.zuzex.education.repository;

import com.zuzex.education.model.db.House;
import com.zuzex.education.model.db.Person;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HouseRepository extends JpaRepository<House, UUID> {
    @Query(value = """
                        SELECT DISTINCT owners
                        FROM House house
                        JOIN house.owners owners
                        JOIN house.address address
                        WHERE address.street = :street
                    """)
    List<Person> findOwnersByHouseStreet(String street);

    @Modifying
    @Query(value = "DELETE FROM people_houses WHERE house_id = :houseId", nativeQuery = true)
    void deleteFromPeopleHouses(UUID houseId);

    @Override
    @EntityGraph(attributePaths = {"address"})
    Optional<House> findById(UUID uuid);

    @Override
    @EntityGraph(attributePaths = {"address"})
    List<House> findAll();
}
