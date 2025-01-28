package com.zuzex.education.service.impl;

import com.zuzex.education.exception.HouseNotFoundException;
import com.zuzex.education.model.House;
import com.zuzex.education.repository.HouseRepository;
import com.zuzex.education.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    @Override
    public List<House> getAll() {
        return houseRepository.findAll();
    }

    @Override
    public House get(UUID id) {
        return houseRepository.findById(id).orElseThrow(() -> new HouseNotFoundException(id));
    }

    @Override
    public House create(House house) {
        return houseRepository.save(
                house.toBuilder()
                        .id(UUID.randomUUID())
                        .build()
        );
    }

    @Override
    public House update(House house) {
        return houseRepository.save(house);
    }

    @Override
    public void delete(UUID id) {
        houseRepository.deleteById(id);
    }
}
