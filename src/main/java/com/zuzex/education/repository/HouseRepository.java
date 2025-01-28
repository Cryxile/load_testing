package com.zuzex.education.repository;

import com.zuzex.education.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HouseRepository extends JpaRepository<House, UUID> {
}
