package com.zuzex.education.repository;

import com.zuzex.education.model.db.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    @Modifying
    @Query(value = "DELETE FROM people_houses WHERE owner_id = :ownerId", nativeQuery = true)
    void deleteFromPeopleHouses(UUID ownerId);
}
