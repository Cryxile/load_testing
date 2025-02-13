package com.zuzex.education.repository;

import com.zuzex.education.model.db.Passport;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PassportRepository extends JpaRepository<Passport, UUID> {
    @Query(value = """
                SELECT pass
                FROM Passport pass
                JOIN FETCH pass.residentAddress
                JOIN FETCH pass.owner
                WHERE pass.gender = 'Male' AND pass.lastName ILIKE :firstCharacter%
            """)
    List<Passport> findAllMaleByLastNameFirstCharacter(Character firstCharacter);

    @Modifying
    @Query(value = "DELETE FROM passports WHERE owner_id = :ownerId", nativeQuery = true)
    void deleteByOwner(UUID ownerId);

    @Override
    @EntityGraph(attributePaths = {"owner", "residentAddress"})
    Optional<Passport> findById(UUID uuid);

    @Override
    @EntityGraph(attributePaths = {"owner", "residentAddress"})
    List<Passport> findAll();
}
