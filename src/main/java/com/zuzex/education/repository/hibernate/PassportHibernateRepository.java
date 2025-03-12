package com.zuzex.education.repository.hibernate;

import com.zuzex.education.model.db.Passport;
import com.zuzex.education.repository.PassportRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

@Profile("hibernate")
public interface PassportHibernateRepository extends JpaRepository<Passport, UUID>, PassportRepository {
    @Query(value = """
                SELECT pass
                FROM Passport pass
                WHERE pass.gender = 'Male' AND pass.lastName ILIKE :firstCharacter%
            """)
    List<Passport> findAllMaleByLastNameFirstCharacter(Character firstCharacter);

    @Modifying
    @Query(value = "DELETE FROM passports WHERE owner_id = :ownerId", nativeQuery = true)
    void deleteByOwner(UUID ownerId);
}
