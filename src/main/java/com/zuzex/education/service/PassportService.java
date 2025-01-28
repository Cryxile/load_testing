package com.zuzex.education.service;

import com.zuzex.education.model.Passport;

import java.util.List;
import java.util.UUID;

public interface PassportService {
    List<Passport> getAll();

    Passport get(UUID id);

    Passport create(Passport passport);

    Passport update(Passport passport);

    void delete(UUID id);
}
