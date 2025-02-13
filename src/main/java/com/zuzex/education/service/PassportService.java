package com.zuzex.education.service;

import com.zuzex.education.model.db.Passport;

import java.util.List;
import java.util.UUID;

public interface PassportService {
    List<Passport> findAll();

    List<Passport> findAllByMaleLastNameFirstCharacter(Character initial);

    Passport get(UUID id);

    Passport create(Passport passport);

    Passport update(Passport passport);

    void delete(UUID id);

    void deleteByOwner(UUID ownerId);
}
