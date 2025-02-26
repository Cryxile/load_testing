package com.zuzex.education.repository.hibernate;

import com.zuzex.education.model.db.Person;
import com.zuzex.education.repository.PersonRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

@Profile("hibernate")
public interface PersonHibernateRepository extends JpaRepository<Person, UUID>, PersonRepository {
    @Modifying
    @Query(value = "DELETE FROM people_houses WHERE owner_id = :ownerId", nativeQuery = true)
    void deleteFromPeopleHouses(UUID ownerId);
}
