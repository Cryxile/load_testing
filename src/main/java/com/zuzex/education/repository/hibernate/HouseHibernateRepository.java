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
                SELECT DISTINCT p.id, p.height, p.weight, p.hair_color
                FROM people p
                JOIN people_houses ph ON ph.owner_id = p.id
                JOIN houses h ON ph.house_id = h.id
                JOIN addresses a ON h.address_id = a.id
                WHERE a.street = :street
            """, nativeQuery = true)
    List<Person> findOwnersByHouseStreet(String street);

    @Query(value = "SELECT owner_id FROM people_houses WHERE house_id = :houseId", nativeQuery = true)
    Set<UUID> findHouseOwners(UUID houseId);

    @Modifying
    @Query(value = "INSERT INTO people_houses (house_id, owner_id) VALUES (:houseId, :ownerId)", nativeQuery = true)
    void saveOwners(UUID houseId, UUID ownerId);

    @Modifying
    @Query(value = "DELETE FROM people_houses WHERE house_id = :houseId", nativeQuery = true)
    void deleteFromPeopleHouses(UUID houseId);
}
