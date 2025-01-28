package com.zuzex.education.service;

import com.zuzex.education.model.House;

import java.util.List;
import java.util.UUID;

public interface HouseService {
    List<House> getAll();

    House get(UUID id);

    House create(House house);

    House update(House house);

    void delete(UUID id);
}
