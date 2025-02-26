package com.zuzex.education.repository;

import com.zuzex.education.model.db.Passport;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PassportRepository {
    List<Passport> findAll();
    List<Passport> findAllMaleByLastNameFirstCharacter(Character firstCharacter);
    Optional<Passport> findById(UUID id);
    Passport save(Passport passport);
    void deleteById(UUID id);
    void deleteByOwner(UUID id);
}
