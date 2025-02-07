package com.zuzex.education.repository;

import com.zuzex.education.model.db.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PassportRepository extends JpaRepository<Passport, UUID> {
    @Query(value = "SELECT * FROM passports WHERE gender = 'Male' AND last_name ILIKE :firstCharacter%", nativeQuery = true)
    List<Passport> getAllMaleByLastNameFirstCharacter(Character firstCharacter);

    @Modifying
    @Query(value = "DELETE FROM passports WHERE owner_id = :ownerId", nativeQuery = true)
    void deleteByOwner(UUID ownerId);
}
